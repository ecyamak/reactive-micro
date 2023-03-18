FROM maven:3.8.5-openjdk-17 as build
WORKDIR /app
COPY src ./src
COPY pom.xml .
RUN mvn clean package

FROM openjdk:17
COPY --from=build /app/target/discovery-service-1.0.0.jar /app/discovery-service.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "/app/discovery-service.jar"]