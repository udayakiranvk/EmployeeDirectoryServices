FROM openjdk:17-oracle
ADD target/employeedirectoryservices.jar .
ENTRYPOINT ["sh","-c","java -jar /hello-world-rest-api.jar"]
