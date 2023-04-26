curl --location --request GET 'http://10.100.3.137:8088/' \
--header 'Content-Type: application/xml' \
--data '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
    <soapenv:Header>
        <ns1:ibsinfo xmlns:ns1="urn:schemas-iwaysoftware-com:iwse">
            <ns1:service>InvoiceImport_V1</ns1:service>
            <ns1:method>Z_ARIBA_GR_TRANSFER</ns1:method>
            <ns1:license>test</ns1:license>
            <ns1:Username>ARIBA_CPIC</ns1:Username>
            <ns1:Password>ENCR(312531493234280318631613211321732473227321431973252)</ns1:Password>
        </ns1:ibsinfo>
    </soapenv:Header>
    <soap:Body xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
        <ns1:Z_ARIBA_GR_TRANSFER xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ns1="urn:iwaysoftware:ibse:jul2003:Z_ARIBA_GR_TRANSFER">
            <ns1:Z_ARIBA_GR_TRANSFER>
                <ns1:PARTITION>par1iam</ns1:PARTITION>
                <ns1:VARIANT>var1iam</ns1:VARIANT>
                <ns1:GR_ITEM>
                    <ns1:item>
                        <ns1:MBLNR>5000735437</ns1:MBLNR>
                        <ns1:MJAHR>2020</ns1:MJAHR>
                        <ns1:ZEILE>0001</ns1:ZEILE>
                        <ns1:ZQACCEPT>1.00000</ns1:ZQACCEPT>
                        <ns1:ZUACCEPT>PC</ns1:ZUACCEPT>
                        <ns1:ZQREFUS>0.00000</ns1:ZQREFUS>
                        <ns1:ZUREFUS>PC</ns1:ZUREFUS>
                        <ns1:BWTAR/>
                        <ns1:GRUND/>
                        <ns1:ARIBA_GRNO>ST-RC205425</ns1:ARIBA_GRNO>
                        <ns1:ARIBA_ITNO>1</ns1:ARIBA_ITNO>
                        <ns1:NO_MORE_GR>X</ns1:NO_MORE_GR>
                    </ns1:item>
                </ns1:GR_ITEM>
                <ns1:GR_SERIAL>
                    <ns1:item>
                        <ns1:MBLNR>5000735437</ns1:MBLNR>
                        <ns1:MJAHR>2020</ns1:MJAHR>
                        <ns1:ZEILE>0001</ns1:ZEILE>
                        <ns1:SERNR/>
                    </ns1:item>
                </ns1:GR_SERIAL>
            </ns1:Z_ARIBA_GR_TRANSFER>
        </ns1:Z_ARIBA_GR_TRANSFER>
    </soap:Body>
</soapenv:Envelope>'
