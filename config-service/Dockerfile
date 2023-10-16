ARG JAVA_VERSION
FROM openjdk:${JAVA_VERSION}
WORKDIR /app
ARG BUILD_VERSION
COPY /target/config-service-${BUILD_VERSION}.jar /app/config-service-${BUILD_VERSION}.jar
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "/app/config-service-${BUILD_VERSION}.jar"]