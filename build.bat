mvn clean install
or 
mvn dependency:purge-local-repository clean install -U

docker build -t muis-fuse-sap-adapter:iam_0.6.0 .

docker tag muis-fuse-sap-adapter:iam_0.6.0 quay.io/msentissi/muis-fuse-sap-adapter:iam_0.6.0

docker push quay.io/msentissi/muis-fuse-sap-adapter:iam_0.6.0
