#FROM maven:3.5-jdk-8 AS build
#COPY src /usr/src/app/src
#COPY pom.xml /usr/src/app
#RUN mvn -f /usr/src/app/pom.xml clean package


FROM adoptopenjdk/openjdk11:slim
MAINTAINER Diego Rangel <diegorangeljpa@gmail.com>
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
RUN bash -c 'touch /app.jar'
#ENTRYPOINT ["java","-Djava.security.agd=file:/dev/./urandom","-jar","/app.jar"]
ENTRYPOINT ["java","-jar","/app.jar"]