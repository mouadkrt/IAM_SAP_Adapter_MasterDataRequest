package ma.munisys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;

import java.util.HashMap;
import java.util.Properties;

import com.sap.conn.jco.ext.DataProviderException;
import com.sap.conn.jco.ext.DestinationDataEventListener;
import com.sap.conn.jco.ext.DestinationDataProvider;
import com.sap.conn.jco.ext.Environment;


@SpringBootApplication
//@ImportResource({"classpath:spring/camel-context.xml"})
public class Application extends RouteBuilder {

	@Override
	public void configure() { }

    public static void main(String[] args)
    {
        InMemoryDestinationDataProvider memoryProvider=new Application.InMemoryDestinationDataProvider();

        // register the provider with the JCo environment;
        // catch IllegalStateException if an instance is already registered
        try
        {
            Environment.registerDestinationDataProvider(memoryProvider);
        }
        catch (IllegalStateException providerAlreadyRegisteredException)
        {
            // somebody else registered its implementation stop the execution, alternatively you
            // could write it to your logs
            throw new Error(providerAlreadyRegisteredException);
        }

        // set properties for the destination ABAP_AS1 and ...
        memoryProvider.changeProperties(DestinationConcept.SAPqualif.ABAP_AS1,
                getDestinationPropertiesFromUI());

        // ... work with it
			executeCalls(DestinationConcept.SAPqualif.ABAP_AS1);

        // now remove the properties and ...
			// memoryProvider.changeProperties(DestinationConcept.SAPqualif.ABAP_AS1, null);
        // ... and let the test fail
			// executeCalls(DestinationConcept.SAPqualif.ABAP_AS1);
    }

    /**
     * The custom destination data provider implements DestinationDataProvider and provides an implementation for at
     * least getDestinationProperties(String). Whenever possible the implementation should support events and notify the
     * JCo runtime if a destination is being created, changed, or deleted. Otherwise JCo runtime will check regularly if
     * a cached destination configuration is still valid which incurs a performance penalty.
     */
    private static class InMemoryDestinationDataProvider implements DestinationDataProvider
    {
        private DestinationDataEventListener eL;
        private HashMap<String, Properties> secureDBStorage=new HashMap<String, Properties>();

        @Override
        public Properties getDestinationProperties(String destinationName)
        {
            try
            {
                // read the destination from DB
                Properties p=secureDBStorage.get(destinationName);

                // check if all is correct
                if (p!=null&&p.isEmpty())
                    throw new DataProviderException(DataProviderException.Reason.INVALID_CONFIGURATION,
                            "destination configuration is incorrect", null);

                return p;
            }
            catch (RuntimeException re)
            {
                throw new DataProviderException(DataProviderException.Reason.INTERNAL_ERROR, re);
            }
        }

        // An implementation supporting events has to retain the eventListener instance
        // provided by the JCo runtime. This listener instance shall be used to notify
        // the JCo runtime about all changes in destination configurations.
        @Override
        public void setDestinationDataEventListener(DestinationDataEventListener eventListener)
        {
            this.eL=eventListener;
        }

        @Override
        public boolean supportsEvents()
        {
            return true;
        }

        /** implementation that saves the properties in memory */
        void changeProperties(String destName, Properties properties)
        {
            synchronized (secureDBStorage)
            {
                if (properties==null)
                {
                    if (secureDBStorage.remove(destName)!=null)
                        eL.deleted(destName);
                }
                else
                {
                    secureDBStorage.put(destName, properties);
                    eL.updated(destName); // create or updated
                }
            }
        }
    }

    private static Properties getDestinationPropertiesFromUI()
    {
        // adapt parameters in order to configure a valid destination
		
		// Get required value from OS environment :
			String JCO_ASHOST	=	System.getenv("JCO_ASHOST");
			String JCO_SYSNR	=	System.getenv("JCO_SYSNR");
			String JCO_CLIENT	=	System.getenv("JCO_CLIENT");
			String JCO_USER		=	System.getenv("JCO_USER");
			String JCO_PASSWD	=	System.getenv("JCO_PASSWD");
			String JCO_LANG		=	System.getenv("JCO_LANG");
			
			System.out.println("MUIS : JCO_ASHOST="+JCO_ASHOST);
			System.out.println("MUIS : JCO_SYSNR="+JCO_SYSNR);
			System.out.println("MUIS : JCO_CLIENT="+JCO_CLIENT);
			System.out.println("MUIS : JCO_USER="+JCO_USER);
			System.out.println("MUIS : JCO_PASSWD=********");
			System.out.println("MUIS : JCO_LANG="+JCO_LANG);
			
        Properties connectProperties=new Properties();
        connectProperties.setProperty(DestinationDataProvider.JCO_ASHOST, JCO_ASHOST);
        connectProperties.setProperty(DestinationDataProvider.JCO_SYSNR, JCO_SYSNR);
        connectProperties.setProperty(DestinationDataProvider.JCO_CLIENT, JCO_CLIENT);
        connectProperties.setProperty(DestinationDataProvider.JCO_USER, JCO_USER);
        connectProperties.setProperty(DestinationDataProvider.JCO_PASSWD, JCO_PASSWD);
        connectProperties.setProperty(DestinationDataProvider.JCO_LANG, JCO_LANG);
        return connectProperties;
    }

    private static void executeCalls(String destName)
    {
        try
        {
            JCoDestination dest=JCoDestinationManager.getDestination(destName);
            // Ping SAP :
				dest.ping();
				System.out.println("Destination "+destName+" works");
			// or execute any other remote sap function :
				
					String repoName  =dest.getRepository().getName();
					System.out.println("Reposiroty name =  " + repoName);
					
					String[] cachedFunctionTemplateNames  =dest.getRepository().getCachedFunctionTemplateNames();
					System.out.println("Reposiroty cachedFunctionTemplateNames length  =  " + cachedFunctionTemplateNames.length);
					System.out.println("Reposiroty cachedFunctionTemplateNames =  " + String.join(", ", cachedFunctionTemplateNames));
					
				//String sapFunction = "RFC_PING";
				//String sapFunction = "STFC_CONNECTION";
				String sapFunction = "ZARIBA_INTERNAL_ORDER";
				JCoFunction function=dest.getRepository().getFunction(sapFunction);
				System.out.println(sapFunction + " as XML : " + function.toXML() );

				if (function==null)
						throw new RuntimeException(sapFunction + " not found in SAP.");
				function.getImportParameterList().setValue("ENCODING", "UTF-8");
				function.getImportParameterList().setValue("FILE_NAME", "/exportQ11/DATAARIBA/Asset.csv");
				function.getImportParameterList().setValue("PARTITION", "PAR1IAM");
				function.getImportParameterList().setValue("VARIANT", "VAR1IAM");
				//function.getImportParameterList().getListMetaData();
				try
					{
						// execute, i.e. send the function representation to the ABAP system addressed
						// by the specified destination, invoke it there, and retrieve the function
						// result sent back by the system
						// All necessary conversions between Java and ABAP data types are done automatically.
						function.execute(dest);
					}
					catch (AbapException e)
					{
						System.out.println(e);
						return;
					}
        }
        catch (JCoException e)
        {
            e.printStackTrace();
            System.out.println("Execution on destination "+destName+" failed");
        }
    }

}
