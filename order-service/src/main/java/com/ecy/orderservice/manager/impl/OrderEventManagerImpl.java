package com.ecy.orderservice.manager.impl;

import com.ecy.data.dto.OrderDTO;
import com.ecy.data.enums.InventoryStatus;
import com.ecy.data.enums.OrderStatus;
import com.ecy.data.enums.PaymentStatus;
import com.ecy.data.event.OrderEvent;
import com.ecy.orderservice.manager.OrderEventManager;
import com.ecy.orderservice.model.Order;
import com.ecy.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * Author: ecyamak
 * Date: 25.08.2023
 * Time: 00:11
 */

@Component
@RequiredArgsConstructor
public class OrderEventManagerImpl implements OrderEventManager {

    private final Sinks.Many<OrderEvent> orderEventSink;
    private final OrderService orderService;

    @Override
    public Mono<Order> updateOrder(String orderId, Consumer<Order> consumer) {
        var order = orderService.get(orderId).block();
        consumer.accept(order);
        updateOrder(order);
        return orderService.save(order);

    }

    private Mono<Void> updateOrder(Order order) {
        if (Objects.isNull(order.getPaymentStatus()) || Objects.isNull(order.getInventoryStatus()))
            return Mono.empty();
        var isComplete = order.getPaymentStatus().equals(PaymentStatus.RECEIVED) &&
                order.getInventoryStatus().equals(InventoryStatus.RECEIVED);
        var orderStatus = isComplete ? OrderStatus.COMPLETED : OrderStatus.REJECTED;
        order.setOrderStatus(orderStatus);
        return isComplete ? Mono.empty() : publishOrderEvent(order, orderStatus);
    }

    public Mono<Void> publishOrderEvent(Order order, OrderStatus orderStatus) {
        var orderDTO = OrderDTO.builder()
                .orderId(order.getOrderId())
                .productId(order.getProductId())
                .amount(order.getQuantity())
                .userId(order.getUserId())
                .build();
        return Mono.just(orderEventSink.tryEmitNext(OrderEvent.of(orderDTO, orderStatus))).then();
    }

}