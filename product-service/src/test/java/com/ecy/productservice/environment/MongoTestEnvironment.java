package com.ecy.productservice.environment;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

/**
 * Author: ecyamak
 * Date: 16.10.2023
 * Time: 18:50
 */

public abstract class MongoTestEnvironment {

    @Container
    static MongoDBContainer mongo = new MongoDBContainer(DockerImageName.parse("mongo:latest"));

    @DynamicPropertySource
    static void mongoProperties(DynamicPropertyRegistry registry) {
        mongo.start();
        registry.add("spring.data.mongodb.uri", mongo::getReplicaSetUrl);
    }

}
