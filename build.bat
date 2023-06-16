mvn clean install
or 
mvn dependency:purge-local-repository clean install -U

docker build -t muis-fuse-sap-adapter:iam_0.4.9 .

docker tag muis-fuse-sap-adapter:iam_0.4.9 quay.io/msentissi/muis-fuse-sap-adapter:iam_0.4.9

docker push quay.io/msentissi/muis-fuse-sap-adapter:iam_0.4.9
