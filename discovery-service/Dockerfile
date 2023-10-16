ARG JAVA_VERSION
FROM openjdk:${JAVA_VERSION}
WORKDIR /app
ARG BUILD_VERSION
COPY /target/discovery-service-${BUILD_VERSION}.jar /app/discovery-service-${BUILD_VERSION}.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "/app/discovery-service-${BUILD_VERSION}.jar"]