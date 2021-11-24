package ch.lukb.bibliothek.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import org.apache.camel.Exchange;

@Component
public class Routes extends RouteBuilder {

    @Override
    public void configure() {

        // load books into api by calling init endpoint on caml boot
        from("timer: //runOnce?repeatCount=1&delay=500")
                .to("http://localhost:8080/initial");

        from("undertow:http://0.0.0.0:19000/books")
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
                .to("jslt:transformation/multiple.json");

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

    }

}