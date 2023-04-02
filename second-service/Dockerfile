FROM openjdk:17
WORKDIR /app
COPY /target/second-service-1.0.0.jar /app/second-service.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "/app/second-service.jar"]