package com.ecy.productservice.unit;

import com.ecy.productservice.dto.ProductResponse;
import com.ecy.productservice.model.Product;
import com.ecy.productservice.repository.ProductRepository;
import com.ecy.productservice.service.impl.ProductServiceImpl;
import com.ecy.productservice.util.ProductMockUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Author: ecyamak
 * Date: 16.10.2023
 * Time: 16:22
 */

@ExtendWith(SpringExtension.class)
class ProductServiceTest {

    @InjectMocks
    ProductServiceImpl productService;

    @Mock
    ReactiveMongoTemplate reactiveMongoTemplate;

    @Mock
    ProductRepository productRepository;

    @Mock
    ModelMapper modelMapper;

    @Test
    void testCreate() {
        when(modelMapper.map(ProductMockUtil.mockProductRequest(), Product.class))
                .thenReturn(ProductMockUtil.mockProduct());
        when(productRepository.save(ProductMockUtil.mockProduct())).thenReturn(Mono.empty());
        StepVerifier.create(productService.create(ProductMockUtil.mockProductRequest())).verifyComplete();
    }

    @Test
    void testGetAll() {
        when(reactiveMongoTemplate.aggregate(any(Aggregation.class), eq(Product.class), eq(ProductResponse.class)))
                .thenReturn(Flux.just(ProductMockUtil.mockProductResponse()));
        StepVerifier.create(productService.getAll(ProductMockUtil.mockSearchCriteria()))
                .consumeNextWith(productResponse -> assertEquals(productResponse, ProductMockUtil.mockProductResponse()))
                .verifyComplete();
    }

    @Test
    void testDeleteAll() {
        when(productRepository.deleteAll()).thenReturn(Mono.empty());
        StepVerifier.create(productService.deleteAll()).verifyComplete();
    }



}
