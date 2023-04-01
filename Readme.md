cmd as admin : 
    mvn install:install-file -DgroupId=org.hibersap -DartifactId=sapjco3 -Dversion=3.0 -Dpackaging=jar -Dfile=.\sapjco3-3.0.jar
     Installing C:\Users\msentissi\Documents\CLIENTS\IAM\API Mgmt\SOAP\Code\sap-adapter\sapjco3-3.0.jar to C:\Users\msentissi\.m2\repository\org\hibersap\sapjco3\3.0\sapjco3-3.0.jar
    [INFO] Installing C:\Users\MSENTI~1\AppData\Local\Temp\mvninstall122049965864333698.pom to C:\Users\msentissi\.m2\repository\org\hibersap\sapjco3\3.0\sapjco3-3.0.pom
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS

mvn clean install
mvn spring-boot:run