package ma.munisys;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Envelope { 
	public Header Header;
	public Body Body;
	public String soapenv;
	public String urn;
	public String urn1;
	public String text;
}

class Body { 
	public ZARIBA_INVOICED_PO_ITEMS_SOAP ZARIBA_INVOICED_PO_ITEMS_SOAP;
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

public class ZARIBA_INVOICED_PO_ITEMS_SOAP {
	public String ENDDATE;
	public String PARTITION;
	public String STARTDATE;
	public String VARIANT;
	public ZINVPOITEMS ZINVPOITEMS;

    public String toString() {
        // You may print the ZARIBA_INVOICED_PO_ITEMS_SOAP Java object back as a JSON format, to inspect it :
		try { return new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(this); }
		catch (JsonProcessingException  e) { e.printStackTrace(); return "ERROR casting ZARIBA_INVOICED_PO_ITEMS_SOAP object to String"; }
    }
}

class ZINVPOITEMS {
	public ArrayList<ZINVPOITEMS_item> items;
    public ZINVPOITEMS() {
       this.items = new ArrayList<ZINVPOITEMS_item>();
      }
}

class ZINVPOITEMS_item {
    public String EBELN;
    public String EBELP;
    public String QTEFACT;
    public String QTECHU;
    public String QTEFACTPRE;
    public String QTECHUPRE;
    public String QTECIA;
    public String QTECIAPRE;
    public String BSTME;
}