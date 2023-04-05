

package ma.munisys;

import com.sap.conn.jco.ext.DestinationDataProvider;

/**
 * The application does not deal with single connections anymore. Instead it works with logical destinations like ABAP_AS1 and
 * ABAP_AS2 which separates the application logic from technical configuration. JCo retrieves destination information from the
 * registered {@link DestinationDataProvider}. See {@link iamDestinationDataProvider} to understand how to implement your own
 * storage of destinations. For these test examples we use the jcoDestination files in this package. Those are interpreted by
 * the default {@link DestinationDataProvider} built-in to JCo and allow fast proof-of-concepts. Replace the dummy values and
 * put the files in the working directory. However, don't use them in a productive setup, refer to
 * {@link iamDestinationDataProvider} how you have to implement {@link DestinationDataProvider} properly and make sure to use
 * an implementation with a secure storage. The properties that need to be supported by the implementation can be found in the
 * documentation of {@link DestinationDataProvider}.
 */
public class DestinationConcept
{

    public static class SAPqualif
    {

        public static final String ABAP_AS1="ABAP_AS1";

    }
}
