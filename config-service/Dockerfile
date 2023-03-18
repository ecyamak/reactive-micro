FROM maven:3.8.5-openjdk-17 as build
WORKDIR /app
COPY src ./src
COPY pom.xml .
RUN mvn clean package

FROM openjdk:17
COPY --from=build /app/target/config-service-1.0.0.jar /app/config-service.jar
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "/app/config-service.jar"]
