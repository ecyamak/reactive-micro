package com.ecy.orderservice.repository;

import com.ecy.orderservice.dto.OrderResponse;
import com.ecy.orderservice.model.Order;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

/**
 * Author: ecyamak
 * Date: 10.08.2023
 * Time: 23:08
 */

public interface OrderRepository extends ReactiveMongoRepository<Order, String> {

    Flux<OrderResponse> findAllBy();

}