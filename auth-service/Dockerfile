FROM openjdk:17
WORKDIR /app
COPY /target/auth-service-1.0.0.jar /app/auth-service.jar
EXPOSE 8079
ENTRYPOINT ["java", "-jar", "/app/auth-service.jar"]