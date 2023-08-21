package com.ecy.productservice.service.impl;

import com.ecy.productservice.dto.ProductRequest;
import com.ecy.productservice.dto.ProductResponse;
import com.ecy.productservice.model.Product;
import com.ecy.productservice.record.SearchCriteria;
import com.ecy.productservice.repository.ProductRepository;
import com.ecy.productservice.service.ProductService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Author: ecyamak
 * Date: 10.08.2023
 * Time: 20:23
 */

@Service
public class ProductServiceImpl extends AbstractBaseService implements ProductService {

    private final ProductRepository productRepository;

    private ProductServiceImpl(ReactiveMongoTemplate reactiveMongoTemplate,
                               ProductRepository productRepository) {
        super(reactiveMongoTemplate);
        this.productRepository = productRepository;
    }

    @Override
    public Mono<Void> create(ProductRequest productRequest) {
        var product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        return Mono.when(productRepository.save(product));
    }

    @Override
    public Flux<ProductResponse> getAll() {
        return productRepository.findAllByIdNotNull();
    }

    @Override
    public Flux<ProductResponse> getAll(Sort sort) {
        return productRepository.findAllByIdNotNull(sort);
    }

    @Override
    public Flux<ProductResponse> getAll(Pageable pageable) {
        return productRepository.findAllByIdNotNull(pageable);
    }

    @Override
    public Flux<ProductResponse> getAll(SearchCriteria searchCriteria) {
        if (searchCriteria.isFiltered())
            return this.search(searchCriteria, Product.class, ProductResponse.class);
        else if (searchCriteria.isPaged())
            return getAll(searchCriteria.pageable());
        else if (searchCriteria.isSorted())
            return getAll(searchCriteria.sort());
        return getAll();
    }

    @Override
    public Mono<Void> deleteAll() {
        return productRepository.deleteAll();
    }

}