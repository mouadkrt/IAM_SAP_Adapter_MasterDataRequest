FROM registry.redhat.io/ubi8/openjdk-11:1.14-12
#FROM openjdk:19-jdk-alpine3.16
USER root
RUN mkdir -p /opt/app/sap-libs
WORKDIR /opt/app
ARG JAR_FILE=target/Muis-Fuse-SAP-Adapter-1.0.0.jar
COPY ${JAR_FILE} app.jar
COPY sap-libs/* /opt/app/sap-libs
#COPY src /opt/app/src
#COPY pom.xml  /opt/app/pom.xml
ENV LD_LIBRARY_PATH "/opt/app/sap-libs"
ENV CLASSPATH "/opt/app/sap-libs/sapjco3.jar"
ENV PATH "$PATH:/opt/app/sap-libs"
RUN echo "LD_LIBRARY_PATH=$LD_LIBRARY_PATH, CLASSPATH=$CLASSPATH, PATH=$PATH" 

#ENTRYPOINT ["java","-classpath", "/opt/app/sap-libs/sapjco3.jar", "-jar","app.jar"]
ENTRYPOINT ["java","-cp", "sap-libs/sapjco3.jar:app.jar", "org.springframework.boot.loader.JarLauncher"]
#ENTRYPOINT ["/bin/sh"] # Use this entry with openjdk:19-jdk-alpine3.16 image to inspect java env behaviour inside container

# Update version in MuisApp.java ~ line 54
# mvn dependency:tree | grep xyz
# mvn spring-boot:run
# mvn clean install

# Start Docker deamon
# docker login registry.redhat.io 
# docker build -t muis-fuse-sap-adapter:iam_0.4.5 .
# Tag it and push to quay
# docker tag muis-fuse-sap-adapter:iam_0.4.5 quay.io/msentissi/muis-fuse-sap-adapter:iam_0.4.5
# docker push quay.io/msentissi/muis-fuse-sap-adapter:iam_0.4.5
# OR tag it and push to dockerhub
#   docker push msentissi/muis-fuse-sap-adapter:iam_0.4.5

# docker run --rm -ti muis-fuse-sap-adapter:iam_0.4.5 bash