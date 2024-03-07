REM Ctrl-A, Ctrl-C, Ctrl-V into a terminal
mvn clean install
docker build -t muis-fuse-sap-adapter:iam_0.7.9.1-rec .
docker tag muis-fuse-sap-adapter:iam_0.7.9.1-rec quay.io/msentissi/muis-fuse-sap-adapter:iam_0.7.9.1-rec
docker push quay.io/msentissi/muis-fuse-sap-adapter:iam_0.7.9.1-rec
