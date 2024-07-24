// http://www.masterspringboot.com/camel/camel-jms-component-example/
package ma.munisys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        System.out.println("-------------- SAP-ADAPTER-MASTERDATA START version iam_0.1  -----------------------\n");

        MuisApp.registerDestinationDataProvider();
		//if(!MuisApp.MUIS_DEBUG.equals("0"))
        //MuisApp.describeAllAribaFunctions();
        //MuisApp.describeFunction("RFC_READ_TABLE");

        SpringApplication.run(Application.class, args);
    }

}