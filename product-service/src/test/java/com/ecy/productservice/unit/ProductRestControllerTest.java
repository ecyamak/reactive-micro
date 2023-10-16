package com.ecy.productservice.unit;

import com.ecy.productservice.controller.ProductRestController;
import com.ecy.productservice.dto.ProductResponse;
import com.ecy.productservice.service.ProductService;
import com.ecy.productservice.util.ProductMockUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.*;

/**
 * Author: ecyamak
 * Date: 16.10.2023
 * Time: 11:13
 */

@WebFluxTest(ProductRestController.class)
class ProductRestControllerTest {

    @Autowired
    WebTestClient webTestClient;

    @MockBean
    ProductService productService;

    @MockBean
    ReactorLoadBalancerExchangeFilterFunction loadBalancerExchangeFilterFunction;

    @Test
    void testCreateProduct() {
        when(productService.create(ProductMockUtil.mockProductRequest())).thenReturn(Mono.empty());
        webTestClient.post()
                .uri("/product")
                .bodyValue(ProductMockUtil.mockProductRequest())
                .exchange()
                .expectStatus().isCreated();
        verify(productService, times(1)).create(ProductMockUtil.mockProductRequest());
    }

    @Test
    void testGetAllProduct() {
        when(productService.getAll(ProductMockUtil.mockSearchCriteria()))
                .thenReturn(Flux.just(ProductMockUtil.mockProductResponse()));
        webTestClient.get()
                .uri(uriBuilder ->
                        uriBuilder.path("/product/all")
                                .queryParam("filter", "name")
                                .queryParam("value", "Product#1")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(ProductResponse.class).hasSize(1)
                .contains(ProductMockUtil.mockProductResponse());
        verify(productService, times(1)).getAll(ProductMockUtil.mockSearchCriteria());
    }

    @Test
    void testDeleteAllProduct() {
        when(productService.deleteAll()).thenReturn(Mono.empty());
        webTestClient.delete()
                .uri("/product/all")
                .exchange()
                .expectStatus().isNoContent();
        verify(productService, times(1)).deleteAll();
    }

}
