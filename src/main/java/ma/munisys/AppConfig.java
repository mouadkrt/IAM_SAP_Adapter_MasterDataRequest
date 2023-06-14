package ma.munisys;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.apache.camel.component.jms.JmsComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public JmsComponent jmsComponent() throws Exception {
        // Create the connectionfactory which will be used to connect to Artemis
        ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();

        String BROKER_URL = System.getenv().getOrDefault("BROKER_URL", "tcp://localhost:61616");
        String BROKER_USER = System.getenv().getOrDefault("BROKER_USER", "admin");
        String BROKER_PWD = System.getenv().getOrDefault("BROKER_PWD", "123.pwdMunisys");

        System.out.println("Using BROKER_URL : " + BROKER_URL);

        cf.setBrokerURL(BROKER_URL);
        cf.setUser(BROKER_USER);
        cf.setPassword(BROKER_PWD);

        // Create the Camel JMS component and wire it to our Artemis connectionfactory
        JmsComponent jms = new JmsComponent();
        jms.setConnectionFactory(cf);
        return jms;
    }


}