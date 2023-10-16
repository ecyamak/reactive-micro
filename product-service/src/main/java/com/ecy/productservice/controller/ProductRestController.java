package com.ecy.productservice.controller;

import com.ecy.productservice.dto.ProductRequest;
import com.ecy.productservice.dto.ProductResponse;
import com.ecy.productservice.record.SearchCriteria;
import com.ecy.productservice.service.ProductService;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
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
@RequestMapping("/product")
public class ProductRestController {

    private final ProductService productService;
    private final ReactorLoadBalancerExchangeFilterFunction exchangeFilterFunction;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Void> create(@RequestBody ProductRequest productRequest) {
        return productService.create(productRequest);
    }

    @GetMapping("/all")
    public Flux<ProductResponse> getAll(@RequestParam Optional<String> filter,
                                        @RequestParam Optional<String> value,
                                        @RequestParam Optional<String> op,
                                        @RequestParam Optional<Integer> page,
                                        @RequestParam Optional<Integer> size,
                                        @RequestParam Optional<String> sort,
                                        @RequestParam Optional<String> order) {
        return productService.getAll(SearchCriteria.of(filter, value, op, page, size, sort, order));
    }

    @DeleteMapping("/all")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteAll() {
        return productService.deleteAll();
    }

    @CircuitBreaker(name = "ProductServiceCircuitBreaker")
    @GetMapping("/order")
    public Mono<String> order() {
        return WebClient.builder()
                .filter(exchangeFilterFunction).build()
                .get().uri("lb://order-service/order/info")
                .retrieve()
                .bodyToMono(String.class);
    }

    @CircuitBreaker(name = "ProductServiceCircuitBreaker")
    @GetMapping("/circuitbreaker")
    public Mono<String> circuitBreaker() {
        return WebClient.builder()
                .filter(exchangeFilterFunction).build()
                .get().uri("lb://order-service/order/break")
                .retrieve()
                .bodyToMono(String.class);
    }

    @CircuitBreaker(name = "ProductServiceCircuitBreaker")
    @GetMapping("/circuitbreaker/slow")
    public Mono<String> circuitBreakerSlow() {
        return WebClient.builder()
                .filter(exchangeFilterFunction).build()
                .get().uri("lb://order-service/order/slow")
                .retrieve()
                .bodyToMono(String.class);
    }

    @Retry(name = "ProductServiceRetry")
    @GetMapping("/retry")
    public Mono<String> retry(){
        return WebClient.builder()
                .filter(exchangeFilterFunction).build()
                .get().uri("lb://order-service/order/break")
                .retrieve()
                .bodyToMono(String.class);
    }

    @TimeLimiter(name = "ProductServiceTimeLimiter")
    @GetMapping("/timelimiter")
    public Mono<String> timeLimiter() {
        return WebClient.builder()
                .filter(exchangeFilterFunction).build()
                .get().uri("lb://order-service/order/slow")
                .retrieve()
                .bodyToMono(String.class);
    }

    @Bulkhead(name = "ProductServiceBulkhead")
    @GetMapping("/bulkhead")
    public Mono<String> bulkhead() {
        return WebClient.builder()
                .filter(exchangeFilterFunction).build()
                .get().uri("lb://order-service/order/slow")
                .retrieve()
                .bodyToMono(String.class);
    }

    @RateLimiter(name = "ProductServiceRateLimiter")
    @GetMapping("/ratelimiter")
    public Mono<String> ratelimiter() {
        return WebClient.builder()
                .filter(exchangeFilterFunction).build()
                .get().uri("lb://order-service/order/info")
                .retrieve()
                .bodyToMono(String.class);
    }
}