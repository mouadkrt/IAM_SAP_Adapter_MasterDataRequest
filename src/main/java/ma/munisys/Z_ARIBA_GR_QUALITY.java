package ma.munisys;

// ReceiptImport_V1

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.github.underscore.U; // https://javadev.github.io/underscore-java/
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoTable;

public class Z_ARIBA_GR_QUALITY {

	public JCoFunction currentSapFunction;
	public String PARTITION;
	public String VARIANT;
	public String STARTDATE;
	public GOOD_RECEIPT_PO GOOD_RECEIPT_PO;
	
	public Z_ARIBA_GR_QUALITY() {
		this.PARTITION = "";
		this.VARIANT  = "";
		// @JsonFormat(pattern="yyyy/MM/dd")
		this.STARTDATE = "";

		this.GOOD_RECEIPT_PO 		= new GOOD_RECEIPT_PO();
		this.GOOD_RECEIPT_PO.items 	=  new ArrayList<>();
	}
	
	class GOOD_RECEIPT_PO {public ArrayList<GOOD_RECEIPT_PO_Items> items;}
	@JsonIgnoreProperties(ignoreUnknown = true)
	static class GOOD_RECEIPT_PO_Items {
		public String MBLNR;
		public String MJAHR;
		public String BLDAT;
		public String BUDAT;
		public String CPUDT;
		public String CPUTM;
		public String AEDAT;
		public String USNAM;
		public String XBLNR;
		public String BKTXT;
		public String ZEILE;
		public String BWART;
		public String MATNR;
		public String ERFMG;
		public String ERFME;
		public String LSMNG;
		public String LSMEH;
		public String WERKS;
		public String LGORT;
		public String BWTAR;
		public String EBELN;
		public String EBELP;
		public String INSMK;
		public String ELIKZ;
		public String WEMPF;
		public String ABLAD;
		public String SGTXT;
		public String SJAHR;
		public String SMBLN;
		public String SMBLP;
	}

    public String toString() {
        // You may print the Z_ARIBA_GR_QUALITY Java object back as a JSON format, to inspect it :
		try { 
			ObjectMapper mapper = new ObjectMapper();
			mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
			return mapper.writer().withDefaultPrettyPrinter().writeValueAsString(this); }
		catch (JsonProcessingException  e) { e.printStackTrace(); return "ERROR casting Z_ARIBA_GR_QUALITY object to String"; }
    }

    class Envelope { 
        public Header Header;
        public Body Body;
        public String soapenv;
        public String urn;
        public String urn1;
        public String text;
    }

    class Body { 
        public Z_ARIBA_GR_QUALITY Z_ARIBA_GR_QUALITY;
    }
	
    class Header { 
        public ibsinfo ibsinfo;
    }

    class ibsinfo { 
        public String service;
        public String method;
        public String license;
        public String Username;
        public String Password;
    }

    // The following function will help store all Ariba data (Sent over the received http body/SoapBody), into a well formated Java object (Designed to mimic the http soap xml received)
	// The resulting instance will be then handed over to the SAP function for processing
	public static Z_ARIBA_GR_QUALITY create_Z_ARIBA_GR_QUALITY_ObjectFromXML(String httpBody)  {
		// https://javadev.github.io/underscore-java/
			Map<String, Object> map = U.fromXmlWithoutNamespacesAndAttributes(httpBody);
			System.out.println("\n U.fromXmlWithoutNamespacesAndAttributes(httpBody) : \n");
			System.out.println(map);
		
            Z_ARIBA_GR_QUALITY	z_ariba_gr_quality = new Z_ARIBA_GR_QUALITY();
		
		Map<String, Object> soap_envelope = (Map<String, Object>) map.get("Envelope");
		Application.muis_debug("soap_envelope", soap_envelope);
		
		Map<String, Object> soap_body = (Map<String, Object>) soap_envelope.get("Body");
		Application.muis_debug("soap_body", soap_body);
		
		Map<String, Object> Z_ARIBA_GR_QUALITYY = (Map<String, Object>) soap_body.get("Z_ARIBA_GR_QUALITY");
		Application.muis_debug("Z_ARIBA_GR_QUALITYY", Z_ARIBA_GR_QUALITYY);
		
		// SAP Scalars :
		Map<String, Object> Z_ARIBA_GR_QUALITYY2 = (Map<String, Object>) Z_ARIBA_GR_QUALITYY.get("Z_ARIBA_GR_QUALITY");
			Application.muis_debug("Z_ARIBA_GR_QUALITYY2", Z_ARIBA_GR_QUALITYY2);
			z_ariba_gr_quality.PARTITION =  !(Z_ARIBA_GR_QUALITYY2.get("PARTITION") instanceof String) ? "" : (String) Z_ARIBA_GR_QUALITYY2.get("PARTITION");
			z_ariba_gr_quality.VARIANT = !(Z_ARIBA_GR_QUALITYY2.get("VARIANT") instanceof String) ? "" : (String) Z_ARIBA_GR_QUALITYY2.get("VARIANT");
			z_ariba_gr_quality.STARTDATE = !(Z_ARIBA_GR_QUALITYY2.get("STARTDATE") instanceof String) ? "" : (String) Z_ARIBA_GR_QUALITYY2.get("STARTDATE");
		
		// SAP Tables :
		Map<String, Object> GOOD_RECEIPT_PO2 = (Map<String, Object>) Z_ARIBA_GR_QUALITYY2.get("GOOD_RECEIPT_PO");
			Application.muis_debug("GOOD_RECEIPT_PO2", GOOD_RECEIPT_PO2);
			z_ariba_gr_quality.GOOD_RECEIPT_PO.items = Application.getItemsAsArrayList((LinkedHashMap<String, Object>) GOOD_RECEIPT_PO2, GOOD_RECEIPT_PO_Items.class);
			
		return z_ariba_gr_quality;
	}

    public void execute_SapFunc_Z_ARIBA_GR_QUALITY(final Exchange exchange)
    {
		final Message message = exchange.getIn();
		String body = message.getBody(String.class);
		System.out.println("- MUIS : Received HTTP body in execute_SapFunc_Z_ARIBA_GR_QUALITY() : " + body);

		Z_ARIBA_GR_QUALITY z_ariba_gr_quality = create_Z_ARIBA_GR_QUALITY_ObjectFromXML(body);
		
		System.out.println("MUIS : Parsing HTTP XML Body : Extracted vars are : ");
		System.out.println("MUIS : z_ariba_gr_quality = \n" + z_ariba_gr_quality);

        try
        {
				Application.muis_debug("MUIS : Reposiroty name dest.getRepository().getName() ", Application.dest.getRepository().getName());
					
				String sapFunctionStr = "Z_ARIBA_GR_QUALITY"; // You may also explore other sap fucniton : "RFC_PING", "STFC_CONNECTION" ...
				this.currentSapFunction = Application.dest.getRepository().getFunction(sapFunctionStr);
				if (this.currentSapFunction==null) throw new RuntimeException(this.currentSapFunction + " not found in SAP.");
				
				Application.describeFunction(this.currentSapFunction);
				
				// SAP Scalar fields
				this.currentSapFunction.getImportParameterList().setValue("PARTITION", z_ariba_gr_quality.PARTITION);
				this.currentSapFunction.getImportParameterList().setValue("VARIANT", z_ariba_gr_quality.VARIANT);
				this.currentSapFunction.getImportParameterList().setValue("STARTDATE", z_ariba_gr_quality.STARTDATE);
				
				// SAP Tables :
				Application.feed_SAP_Table("GOOD_RECEIPT_PO", z_ariba_gr_quality.GOOD_RECEIPT_PO.items, GOOD_RECEIPT_PO_Items.class, this.currentSapFunction);
		
				
				try {
                    this.currentSapFunction.execute(Application.dest);
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
            System.out.println("Execution on destination  failed");
        }
    }

	public void read_SapFunc_Z_ARIBA_GR_QUALITY_Response(Exchange exchange) {

		String sapFunctionStr = this.currentSapFunction.getName();
		Application.muis_debug("read_SapFunc_Z_ARIBA_GR_QUALITY_Response", "Processing SAP function " + sapFunctionStr + " output tables :");
		
		// Let's build our soap response step by step -Each time seeking some values from the SAP response values/tables/..etc :
		String newBody ="<SOAP-ENV:Envelope xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><SOAP-ENV:Body>";
		newBody += "<Z_ARIBA_GR_QUALITYResponse xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns=\"urn:iwaysoftware:ibse:jul2003:Z_ARIBA_GR_QUALITY:response\"><Z_ARIBA_GR_QUALITY.Response>";
		
		JCoTable sapTbl;
		Map<String, String> sapTables = Map.ofEntries(
			Map.entry("ZXTEMMIGO","GOOD_RECEIPT_PO")
		);
		
		for (Map.Entry<String, String> entry : sapTables.entrySet()) {
			String tblCode = entry.getKey();
			String tblName = entry.getValue();
			sapTbl = this.currentSapFunction.getTableParameterList().getTable(tblName);
			String xml_TblOut_Str = sapTbl.getNumRows() > 0 ? sapTbl.toXML().replaceAll(tblCode, tblName) : "<"+tblName+"/>";
			newBody +=  xml_TblOut_Str; // Tables
		}
		
		newBody += "</Z_ARIBA_GR_QUALITY.Response></Z_ARIBA_GR_QUALITYResponse>";
		newBody += "</SOAP-ENV:Body></SOAP-ENV:Envelope>";
				
		final Message message = exchange.getIn();
		message.setBody(newBody);
		System.out.println("- MUIS : New soap body set in read_SapFunc_Z_ARIBA_GR_QUALITY_Response() to : " + newBody);
	}

}
