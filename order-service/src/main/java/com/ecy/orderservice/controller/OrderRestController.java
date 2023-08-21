package com.ecy.orderservice.controller;

import com.ecy.orderservice.dto.OrderRequest;
import com.ecy.orderservice.dto.OrderResponse;
import com.ecy.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Author: ecyamak
 * Date: 10.08.2023
 * Time: 23:15
 */

@RestController
@RequiredArgsConstructor
public class OrderRestController {

    private final OrderService orderService;

    @PostMapping("/order")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Void> create(@RequestBody OrderRequest orderRequest) {
        return orderService.create(orderRequest);
    }

    @GetMapping("/orders")
    public Flux<OrderResponse> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/order/info")
    public Mono<String> orderInfo() {
        return Mono.just("This is order service");
    }

    @GetMapping("/order/break")
    public Mono<String> orderBreak() {
        return Mono.error(new RuntimeException("Order error"));
    }

    @GetMapping("/order/slow")
    public Mono<String> orderSlow() throws InterruptedException {
        Thread.sleep(5000);
        return Mono.just("This is order service");
    }
}