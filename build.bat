mvn clean install
or 
mvn dependency:purge-local-repository clean install -U

docker build -t muis-fuse-sap-adapter:iam_0.6.1 .

docker tag muis-fuse-sap-adapter:iam_0.6.1 quay.io/msentissi/muis-fuse-sap-adapter:iam_0.6.1

docker push quay.io/msentissi/muis-fuse-sap-adapter:iam_0.6.1
