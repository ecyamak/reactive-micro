package com.ecy.orderservice.service.impl;

import com.ecy.orderservice.model.Order;
import com.ecy.orderservice.repository.OrderRepository;
import com.ecy.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * Author: ecyamak
 * Date: 28.08.2023
 * Time: 21:32
 */

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Mono<Order> save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Mono<Order> get(String orderId) {
        return orderRepository.findById(orderId);
    }

}