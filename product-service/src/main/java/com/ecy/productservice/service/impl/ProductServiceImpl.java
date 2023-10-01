package com.ecy.productservice.service.impl;

import com.ecy.productservice.dto.ProductRequest;
import com.ecy.productservice.dto.ProductResponse;
import com.ecy.productservice.model.Product;
import com.ecy.productservice.record.SearchCriteria;
import com.ecy.productservice.repository.ProductRepository;
import com.ecy.productservice.service.ProductService;
import org.modelmapper.ModelMapper;
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
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ReactiveMongoTemplate reactiveMongoTemplate,
                               ProductRepository productRepository,
                               ModelMapper modelMapper) {
        super(reactiveMongoTemplate);
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Mono<Void> create(ProductRequest productRequest) {
        var product = modelMapper.map(productRequest, Product.class);
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