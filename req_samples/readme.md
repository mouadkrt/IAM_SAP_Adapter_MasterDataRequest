# About files naming in this folder :

- *.req.in.TRF.xml is an example of the initial request (made by a client caller) going into the transformation POD

- *.req.in.ADAPTER_(TRF.out).xml is an example of the transformed request going OUT OF the transformation POD, and INTO the SAP ADAPTER POD

- *.res.out.ADAPTER..xml is an example of the response going OUT OF the SAP ADAPTER, and INTO TO the transformation POD

- *.res.in.TRF_(ADAPTER.out).xml is an example of the response going OUT OF the transformation POD (to the initial client caller)