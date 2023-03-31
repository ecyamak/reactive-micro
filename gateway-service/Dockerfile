FROM openjdk:17
WORKDIR /app
COPY /target/gateway-service-1.0.0.jar /app/gateway-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/gateway-service.jar"]