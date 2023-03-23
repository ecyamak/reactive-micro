FROM maven:3.8.5-openjdk-17 as build
WORKDIR /app
COPY src ./src
COPY pom.xml .
RUN mvn clean package

FROM openjdk:17
COPY --from=build /app/target/second-service-1.0.0.jar /app/second-service.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "/app/second-service.jar"]