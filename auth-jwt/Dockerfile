FROM maven:3.8.5-openjdk-17
WORKDIR /app
COPY src ./src
COPY pom.xml .
RUN mvn clean package