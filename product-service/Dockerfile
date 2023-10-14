FROM openjdk:17
WORKDIR /app
COPY /target/product-service-1.0.0.jar /app/product-service.jar
EXPOSE 8091
ENTRYPOINT ["java", "-jar", "/app/product-service.jar"]