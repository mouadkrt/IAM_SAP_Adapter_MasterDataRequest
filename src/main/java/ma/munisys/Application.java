// http://www.masterspringboot.com/camel/camel-jms-component-example/
package ma.munisys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        System.out.println("-------------- SAP-ADAPTER START version iam_0.3.2 (using AMQ)  -----------------------\n");
        SpringApplication.run(Application.class, args);
    }

}