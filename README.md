Go to <Installed_Location>\jasypt-1.9.3\lib

Encryption command:
java -cp jasypt-1.9.3.jar org.jasypt.intf.cli.JasyptPBEStringEncryptionCLI input="my-secret-to-encrypt" password=master-password algorithm=PBEWithMD5AndDES

Decryption command:
java -cp jasypt-1.9.3.jar org.jasypt.intf.cli.JasyptPBEStringDecryptionCLI input="3YAI79Zf8JzqNCoHB4ukyxD1fV33gs7v" password=master-password algorithm=PBEWithMD5AndDES

You can add key in application properties as jasypt.encryptor.password=SimplePassword or you can also give it on runtime --d jasypt.encryptor.password=SimplePassword




Steps
-----

1. Clone the project
2. Go to root folder where pom.xml is
3. To build: mvn clean install
4. Run command: mvn spring-boot:run