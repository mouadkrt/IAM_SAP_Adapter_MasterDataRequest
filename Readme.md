# sapjco install on windows :
Add C:\Users\msentissi\Documents\CLIENTS\IAM\API Mgmt\SOAP\Code\sap-adapter\sapjco31P_7-20009381-win64 to 
CLASSPATH and LD_LIBRARY_PATH Windows Env var.
# Smoke test on Windows :
C:\Users\msentissi\Documents\CLIENTS\IAM\API Mgmt\SOAP\Code\sap-adapter> 
java -jar .\sapjco31P_7-20009381-win64\sapjco3.jar
OR just double-click on the sapjco3.jar file
# Install sapjco into maven repo :
cmd as admin : 
    mvn install:install-file -DgroupId=org.hibersap -DartifactId=sapjco3 -Dversion=3.0 -Dpackaging=jar -Dfile=.\sapjco3-3.0.jar
     Installing C:\Users\msentissi\Documents\CLIENTS\IAM\API Mgmt\SOAP\Code\sap-adapter\sapjco3-3.0.jar to C:\Users\msentissi\.m2\repository\org\hibersap\sapjco3\3.0\sapjco3-3.0.jar
    [INFO] Installing C:\Users\MSENTI~1\AppData\Local\Temp\mvninstall122049965864333698.pom to C:\Users\msentissi\.m2\repository\org\hibersap\sapjco3\3.0\sapjco3-3.0.pom
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS

mvn clean install
mvn spring-boot:run
