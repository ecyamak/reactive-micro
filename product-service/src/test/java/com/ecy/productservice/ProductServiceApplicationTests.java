package com.ecy.productservice;

import com.ecy.productservice.environment.MongoTestEnvironment;
import com.ecy.productservice.util.ProductMockUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests extends MongoTestEnvironment {

    @LocalServerPort
    int port;

    @Test
    void contextLoads(ApplicationContext applicationContext) {
        assertThat(applicationContext).isNotNull();
    }

    @Test
    void whenPostProduct_thenStatus200() {
        WebTestClient.bindToServer()
                .baseUrl("http://localhost:" + port).build()
                .post()
                .uri("/product")
                .bodyValue(ProductMockUtil.mockProductResponse())
                .exchange()
                .expectStatus().isCreated();
    }

}