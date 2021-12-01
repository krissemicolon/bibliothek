package ch.lukb.bibliothek.camel;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.spi.json.GsonJsonProvider;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import org.apache.camel.Exchange;
import com.jayway.jsonpath.JsonPath;

@Component
public class Routes extends RouteBuilder {

    @Override
    public void configure() {

        // load books into api by calling init endpoint on caml boot
        from("timer: //runOnce?repeatCount=1&delay=500")
                .to("http://localhost:8080/initial");


        from("undertow:http://0.0.0.0:19000/books")
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))

                // get all books
                .removeHeader(Exchange.HTTP_URI)
                .to("direct:books-call")
                .convertBodyTo(String.class)
                .setProperty("books").simple("${body}")

                // get all required authors
                .process(exchange -> {
                    ProducerTemplate template = exchange.getContext().createProducerTemplate();
                    ObjectMapper mapper = new ObjectMapper();

                    // split books into List of Strings
                    List<String> books = StreamSupport.stream(new ObjectMapper().readTree((String) exchange.getProperty("books")).spliterator(), false)
                            .map(JsonNode::toString)
                            .collect(Collectors.toList());

                    // initializing authors map with keys of required author ids from books api call
                    HashMap<Integer, String> authors = (HashMap<Integer, String>) ((List<Integer>) JsonPath.parse((String) exchange.getProperty("books")).read("$[*].authorId"))
                            .parallelStream() // parallelized version. for sequential use: .stream()
                            .distinct()
                            .collect(Collectors.toMap(k -> k, v -> new String()));

                    // filling authors map with values of required authors
                    authors.forEach((k, v) -> authors.put(k, template.requestBody("direct:get-author", k.toString(), String.class)));

                    exchange.setProperty("authors", authors);

                    List<String> transformed = new ArrayList<>();

                    // TODO: Optimize with LinkedHashMap by utilizing insertion order
                    for(String book : books) {
                        transformed.add((String) template.requestBody(
                                "jslt:transformation/single.json",
                                String.format("""
                                {
                                    "author": %s,
                                    "book": %s
                                }
                                """, authors.get(((Integer) JsonPath.parse((String) book).read("$.authorId"))), book),
                                String.class
                        ));
                    }

                    // TODO: Create Lambda Wrapper for Exception Handling
                    String transformedJSON = mapper.createArrayNode().addAll(
                            transformed
                                    .stream()
                                    .map(x -> {
                                        try {
                                            return mapper.readTree(x);
                                        } catch (JsonProcessingException e) {
                                            e.printStackTrace();
                                        }
                                        return null;
                                    })
                                    .collect(Collectors.toList())
                    ).toString();

                    exchange.setProperty("transformed", transformedJSON);
                })
                .setBody(simple("${exchangeProperty.transformed}"));


        from("undertow:http://0.0.0.0:19000/booksZip")
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))

                .removeHeader(Exchange.HTTP_URI)
                .to("direct:books-call")
                .setProperty("books").simple("${body}")

                .removeHeader(Exchange.HTTP_URI)
                .to("direct:authors-call")
                .setProperty("authors").simple("${body}")

                .setBody(
                        simple("""
                                {
                                    "authors": ${exchangeProperty.authors},
                                    "books": ${exchangeProperty.books}
                                }
                                """
                        )
                )
                .to("jslt:transformation/multipleZip.json");


        from("undertow:http://0.0.0.0:19000/book/{bookID}")
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))

                // book call
                .removeHeader(Exchange.HTTP_URI)
                .to("direct:book-call")

                .convertBodyTo(String.class) // converts body from inputstream to string (needed for setting multiple properties from body)
                .setProperty("book").simple("${body}")
                .setProperty("authorId").jsonpath("$.authorId")

                // author call
                .removeHeader(Exchange.HTTP_URI)
                .to("direct:author-call")

                .setProperty("author").simple("${body}")

                // concat & transform
                .setBody(
                        simple("""
                                {
                                    "author": ${exchangeProperty.author},
                                    "book": ${exchangeProperty.book}
                                }
                                """)
                )
                .to("jslt:transformation/single.json");


        // api calls
        from("direct:book-call")
                .toD("http://localhost:8080/book/${header.bookId}");


        from("direct:author-call")
                .toD("http://localhost:8080/author/${exchangeProperty.authorId}");


        from("direct:books-call")
                .to("http://localhost:8080/books");


        from("direct:authors-call")
                .to("http://localhost:8080/authors");


        from("direct:get-author")
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                .removeHeader(Exchange.HTTP_URI)
                .toD("http://localhost:8080/author/${body}");
    }
}