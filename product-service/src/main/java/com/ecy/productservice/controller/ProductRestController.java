package com.ecy.productservice.controller;

import com.ecy.productservice.dto.ProductRequest;
import com.ecy.productservice.dto.ProductResponse;
import com.ecy.productservice.record.SearchCriteria;
import com.ecy.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

/**
 * Author: ecyamak
 * Date: 10.08.2023
 * Time: 20:28
 */

@RestController
@RequiredArgsConstructor
public class ProductRestController {

    private final ProductService productService;

    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Void> create(@RequestBody ProductRequest productRequest) {
        return productService.create(productRequest);
    }

    @GetMapping("/products")
    public Flux<ProductResponse> getAll(@RequestParam Optional<String> filter,
                                        @RequestParam Optional<String> value,
                                        @RequestParam Optional<String> op,
                                        @RequestParam Optional<Integer> page,
                                        @RequestParam Optional<Integer> size,
                                        @RequestParam Optional<String> sort,
                                        @RequestParam Optional<String> order) {
        return productService.getAll(SearchCriteria.of(filter, value, op, page, size, sort, order));
    }

    @DeleteMapping("/products")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteAll() {
        return productService.deleteAll();
    }
}