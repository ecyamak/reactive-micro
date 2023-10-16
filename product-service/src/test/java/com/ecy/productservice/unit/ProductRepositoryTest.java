package com.ecy.productservice.unit;

import com.ecy.productservice.environment.MongoTestEnvironment;
import com.ecy.productservice.repository.ProductRepository;
import com.ecy.productservice.util.ProductMockUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import reactor.test.StepVerifier;

/**
 * Author: ecyamak
 * Date: 16.10.2023
 * Time: 18:38
 */

@DataMongoTest
class ProductRepositoryTest extends MongoTestEnvironment {

    @Autowired
    ProductRepository productRepository;

    @Test
    void testSave() {
        StepVerifier.create(productRepository.save(ProductMockUtil.mockProduct()))
                .expectNextCount(1)
                .verifyComplete();
    }

}
