package com.ecy.orderservice.service;

import com.ecy.orderservice.dto.OrderRequest;
import com.ecy.orderservice.dto.OrderResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Author: ecyamak
 * Date: 10.08.2023
 * Time: 23:09
 */
public interface OrderService {

    Mono<Void> create(OrderRequest orderRequest);

    Flux<OrderResponse> getAll();

}