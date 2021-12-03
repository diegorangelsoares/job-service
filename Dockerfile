FROM adoptopenjdk/openjdk11:alpine
RUN addgroup -S spring && adduser -S spring -G spring
ENV TZ America/Recife
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
CMD ["java", "-jar", "app.jar"]


#RUN apk add --no-cache tzdata
#ENV TZ America/Recife

#COPY target/cards-api-*.jar cards-api.jar

#CMD ["java", "-jar", "app.jar"]