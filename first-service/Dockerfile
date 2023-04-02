FROM openjdk:17
WORKDIR /app
COPY /target/first-service-1.0.0.jar /app/first-service.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app/first-service.jar"]