package com.ecy.orderservice.repository;

import com.ecy.orderservice.dto.OrderResponseDTO;
import com.ecy.orderservice.model.Order;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Author: ecyamak
 * Date: 10.08.2023
 * Time: 23:08
 */

public interface OrderRepository extends ReactiveMongoRepository<Order, String> {

    Mono<OrderResponseDTO> findByOrderId(String orderId);

    Flux<OrderResponseDTO> findAllBy();

}