package com.ecy.orderservice.service;

import com.ecy.orderservice.dto.OrderRequestDTO;
import com.ecy.orderservice.dto.OrderResponseDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Author: ecyamak
 * Date: 10.08.2023
 * Time: 23:09
 */
public interface OrderRestService {

    Mono<Void> create(OrderRequestDTO orderRequestDTO);

    Mono<OrderResponseDTO> get(String orderId);

    Flux<OrderResponseDTO> getAll();

    Mono<Void> delete(String orderId);

    Mono<Void> deleteAll();

}