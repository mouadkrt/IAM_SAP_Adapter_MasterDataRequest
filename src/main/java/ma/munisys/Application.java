// http://www.masterspringboot.com/camel/camel-jms-component-example/
package ma.munisys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        System.out.println("-------------- SAP-ADAPTER START version iam_0.9.1 (using AMQ)  -----------------------\n");

        MuisApp.registerDestinationDataProvider();
		//if(!MuisApp.MUIS_DEBUG.equals("0"))
        MuisApp.describeAllAribaFunctions();

        SpringApplication.run(Application.class, args);
    }

}