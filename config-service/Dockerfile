FROM openjdk:17
WORKDIR /app
COPY /target/config-service-1.0.0.jar /app/config-service.jar
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "/app/config-service.jar"]