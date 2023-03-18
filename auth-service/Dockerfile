FROM maven:3.8.5-openjdk-17 as build
WORKDIR /app
COPY src ./src
COPY pom.xml .
RUN mvn clean package

FROM openjdk:17
COPY --from=build /app/targer/auth-service-1.0.0.jar /app/auth-service.jar
ENTRYPOINT ["java", "-jar", "/app/auth-service.jar"]

