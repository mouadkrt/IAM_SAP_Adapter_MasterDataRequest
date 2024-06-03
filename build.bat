REM Ctrl-A, Ctrl-C, Ctrl-V into a terminal
mvn clean install
docker build -t muis-fuse-sap-adapter:iam_0.9 .
docker tag muis-fuse-sap-adapter:iam_0.9 quay.io/msentissi/muis-fuse-sap-adapter:iam_0.9
docker push quay.io/msentissi/muis-fuse-sap-adapter:iam_0.9

