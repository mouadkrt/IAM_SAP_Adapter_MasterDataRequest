package ma.munisys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
//@ImportResource({"classpath:spring/camel-context.xml"})
public class Application extends RouteBuilder {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void configure() {

      
    }

}
