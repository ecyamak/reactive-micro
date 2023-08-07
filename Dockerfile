FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package

FROM openjdk:17
COPY --from=build /app/target/reactive-micro-1.0.0.jar /app/reactive-micro.jar
ENTRYPOINT ["java", "-jar", "/app/reactive-micro.jar"]