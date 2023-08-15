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
}