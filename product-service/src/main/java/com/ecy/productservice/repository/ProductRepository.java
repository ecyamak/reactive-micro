package com.ecy.productservice.repository;

import com.ecy.productservice.dto.ProductResponse;
import com.ecy.productservice.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

/**
 * Author: ecyamak
 * Date: 10.08.2023
 * Time: 20:24
 */

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

    Flux<ProductResponse> findAllByIdNotNull();

    Flux<ProductResponse> findAllByIdNotNull(Sort sort);

    Flux<ProductResponse> findAllByIdNotNull(Pageable pageable);

}