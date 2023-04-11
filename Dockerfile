FROM registry.redhat.io/ubi8/openjdk-11:1.14-12
USER root
RUN mkdir -p /opt/app/sap-libs
WORKDIR /opt/app
ARG JAR_FILE=target/Muis-Fuse-SAP-Adapter-1.0.0.jar
COPY ${JAR_FILE} app.jar
COPY sap-libs/*  /opt/app/sap-libs
ENV LD_LIBRARY_PATH ="/opt/app/sap-libs"
ENV CLASSPATH ="/opt/app/sap-libs/sapjco3.jar"
ENV PATH ="$PATH:/opt/app/sap-libs"
RUN echo "LD_LIBRARY_PATH=$LD_LIBRARY_PATH, CLASSPATH=$CLASSPATH, PATH=$PATH" 

ENTRYPOINT ["java","-classpath", "/opt/app/sap-libs/sapjco3.jar", "-jar","app.jar"]


# mvn spring-boot:run
# mvn clean install

# Start Docker deamon
# docker login registry.redhat.io 
# docker build -t muis-fuse-sap-adapter:iam_0.0.1 .
# Tag it and push to quay
# docker tag imuis-fuse-sap-adapter:iam_0.0.1 quay.io/msentissi/muis-fuse-sap-adapter:iam_0.0.1
# docker push quay.io/msentissi/muis-fuse-sap-adapter:iam_0.0.1
# OR tag it and push to dockerhub
# docker push msentissi/muis-fuse-sap-adapter:iam_0.0.1