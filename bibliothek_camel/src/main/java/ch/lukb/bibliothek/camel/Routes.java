package ch.lukb.bibliothek.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;
import java.io.InputStream;
import java.io.StringWriter;

@Component
public class Routes extends RouteBuilder {

    @Override
    public void configure() {

        restConfiguration()
                .host("0.0.0.0")
                .port(1234)
                .bindingMode(RestBindingMode.auto);

        rest("/")
                .get("")
                        .route().routeId("task")
                        .to("direct:processed")
                .endRest();


        // load books into api by calling init endpoint on caml boot
        from("timer: //runOnce?repeatCount=1&delay=500")
                .to("http://localhost:8080/initial");

        from("direct:processed")
                .removeHeaders("CamelHttp*")
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                .to("direct:author-call")
                .setProperty("author").simple("${body}")
                .to("direct:book-call")
                .setProperty("book").simple("${body}")
                .setBody(simple("[${exchangeProperty.author},\n${exchangeProperty.book}]"))
                .to("jslt:transformation/transform.json");

        // api calls
        from("direct:book-call")
                .to("http://localhost:8080/book/4");

        from("direct:author-call")
                .to("http://localhost:8080/author/3");

    }

}