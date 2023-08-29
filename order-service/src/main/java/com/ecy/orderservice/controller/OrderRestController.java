package com.ecy.orderservice.controller;

import com.ecy.orderservice.dto.OrderRequestDTO;
import com.ecy.orderservice.dto.OrderResponseDTO;
import com.ecy.orderservice.service.OrderRestService;
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
@RequestMapping("/order")
public class OrderRestController {

    private final OrderRestService orderRestService;

    @GetMapping("/info")
    public Mono<String> orderInfo() {
        return Mono.just("This is order service.");
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Void> create(@RequestBody OrderRequestDTO orderRequestDTO) {
        return orderRestService.create(orderRequestDTO);
    }

    @GetMapping
    public Mono<OrderResponseDTO> get(@RequestParam String orderId) {
        return orderRestService.get(orderId);
    }

    @GetMapping("/all")
    public Flux<OrderResponseDTO> getAll() {
        return orderRestService.getAll();
    }

    @DeleteMapping
    public Mono<Void> delete(@RequestParam String orderId) {
        return orderRestService.delete(orderId);
    }

    @DeleteMapping("/all")
    public Mono<Void> deleteAll() {
        return orderRestService.deleteAll();
    }

    @GetMapping("/break")
    public Mono<String> orderBreak() {
        return Mono.error(new RuntimeException("Order error"));
    }

    @GetMapping("/slow")
    public Mono<String> orderSlow() throws InterruptedException {
        Thread.sleep(5000);
        return Mono.just("This is order service");
    }

}