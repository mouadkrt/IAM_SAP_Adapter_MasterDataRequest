package ma.munisys;

import java.util.Properties;

import javax.jms.ConnectionFactory;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.apache.camel.component.jms.JmsComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public JmsComponent jmsComponent() throws Exception {
        // Create the connectionfactory which will be used to connect to Artemis
        //ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
        
        
        Properties props = new Properties(); 
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.artemis.jndi.ActiveMQInitialContextFactory"); 
        props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");  // or vm:broker:(tcp://localhost:61616)
        ConnectionFactory cf = (ConnectionFactory) new InitialContext(props);
        

       /*  InitialContext ic = new InitialContext();
        ConnectionFactory cf = (ConnectionFactory) ic.lookup("connectionFactory"); */ // Using jndi.properties file

        String BROKER_URL = System.getenv().getOrDefault("BROKER_URL", "tcp://localhost:61616");
        String BROKER_USER = System.getenv().getOrDefault("BROKER_USER", "admin");
        String BROKER_PWD = System.getenv().getOrDefault("BROKER_PWD", "admin");
        cf.createConnection(BROKER_USER, BROKER_PWD);

        System.out.println("Using BROKER_URL : " + BROKER_URL);

        /* cf.setBrokerURL(BROKER_URL);
        cf.setUser(BROKER_USER);
        cf.setPassword(BROKER_PWD);
 */
        // Create the Camel JMS component and wire it to our Artemis connectionfactory
        JmsComponent jms = new JmsComponent();
        jms.setConnectionFactory(cf);
        return jms;
    }

}