package com.ecy.orderservice.service;

import com.ecy.orderservice.model.Order;
import reactor.core.publisher.Mono;

/**
 * Author: ecyamak
 * Date: 28.08.2023
 * Time: 00:56
 */

public interface OrderService {

    Mono<Order> save(Order order);

    Mono<Order> get(String orderId);

}