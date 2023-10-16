ARG JAVA_VERSION
FROM openjdk:${JAVA_VERSION}
WORKDIR /app
ARG BUILD_VERSION
COPY /target/product-service-${BUILD_VERSION}.jar /app/product-service-${BUILD_VERSION}.jar
EXPOSE 8091
ENTRYPOINT ["java", "-jar", "/app/product-service-${BUILD_VERSION}.jar"]