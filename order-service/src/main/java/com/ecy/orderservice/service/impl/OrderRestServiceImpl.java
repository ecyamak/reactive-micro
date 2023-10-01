package com.ecy.orderservice.service.impl;

import com.ecy.data.enums.OrderStatus;
import com.ecy.orderservice.dto.OrderRequestDTO;
import com.ecy.orderservice.dto.OrderResponseDTO;
import com.ecy.orderservice.manager.OrderEventManager;
import com.ecy.orderservice.model.Order;
import com.ecy.orderservice.repository.OrderRepository;
import com.ecy.orderservice.service.OrderRestService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;

/**
 * Author: ecyamak
 * Date: 10.08.2023
 * Time: 23:12
 */

@Service
@RequiredArgsConstructor
public class OrderRestServiceImpl implements OrderRestService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final OrderEventManager orderEventManager;

    @Override
    public Mono<Void> create(OrderRequestDTO orderRequestDTO) {
        var order = modelMapper.map(orderRequestDTO, Order.class);
        order.setOrderDate(Instant.now());
        order.setOrderStatus(OrderStatus.RECEIVED);
        return orderRepository.save(order)
                .map(order1 -> orderEventManager.publishOrderEvent(order1, OrderStatus.RECEIVED))
                .then();
    }

    @Override
    public Mono<OrderResponseDTO> get(String orderId) {
        return orderRepository.findByOrderId(orderId);
    }

    @Override
    public Flux<OrderResponseDTO> getAll() {
        return orderRepository.findAllBy();
    }

    @Override
    public Mono<Void> delete(String orderId) {
        return orderRepository.deleteById(orderId);
    }

    @Override
    public Mono<Void> deleteAll() {
        return orderRepository.deleteAll();
    }

}