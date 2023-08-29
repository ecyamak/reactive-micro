package com.ecy.orderservice.manager;

import com.ecy.data.enums.OrderStatus;
import com.ecy.orderservice.model.Order;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

/**
 * Author: ecyamak
 * Date: 25.08.2023
 * Time: 00:06
 */

public interface OrderEventManager {

    Mono<Order> updateOrder(String id, Consumer<Order> consumer);

    Mono<Void> publishOrderEvent(Order order, OrderStatus orderStatus);

}