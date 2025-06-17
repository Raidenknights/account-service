FROM openjdk:25-jdk-slim

#maintainer of the file
MAINTAINER Manas Vishnoi

#coppy the .jar file to the container
COPY target/accountservice-0.0.1-SNAPSHOT.jar accountservice-0.0.1-SNAPSHOT.jar

EXPOSE 8081

#execute the jar placed inside the image (or basically execute command)
ENTRYPOINT [ "java", "-jar", "accountservice-0.0.1-SNAPSHOT.jar" ]