package com.ecy.orderservice.service.impl;

import com.ecy.orderservice.dto.OrderRequest;
import com.ecy.orderservice.dto.OrderResponse;
import com.ecy.orderservice.model.Order;
import com.ecy.orderservice.repository.OrderRepository;
import com.ecy.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Author: ecyamak
 * Date: 10.08.2023
 * Time: 23:12
 */

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;


    @Override
    public Mono<Void> create(OrderRequest orderRequest) {
        var order = Order.builder()
                .item(orderRequest.getItem())
                .build();
        return Mono.when(orderRepository.save(order));
    }

    @Override
    public Flux<OrderResponse> getAll() {
        return orderRepository.findAllBy();
    }

}