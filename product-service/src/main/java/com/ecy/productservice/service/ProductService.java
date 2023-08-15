package com.ecy.productservice.service;

import com.ecy.productservice.dto.ProductRequest;
import com.ecy.productservice.dto.ProductResponse;
import com.ecy.productservice.record.SearchCriteria;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Author: ecyamak
 * Date: 10.08.2023
 * Time: 20:23
 */

public interface ProductService {

    Mono<Void> create(ProductRequest productRequest);

    Flux<ProductResponse> getAll();

    Flux<ProductResponse> getAll(Sort sort);

    Flux<ProductResponse> getAll(Pageable pageable);

    Flux<ProductResponse> getAll(SearchCriteria searchCriteria);

    Mono<Void> deleteAll();

}