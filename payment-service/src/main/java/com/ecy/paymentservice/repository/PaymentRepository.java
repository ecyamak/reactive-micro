package com.ecy.paymentservice.repository;

import com.ecy.paymentservice.dto.PaymentResponseDTO;
import com.ecy.paymentservice.model.Payment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Author: ecyamak
 * Date: 22.08.2023
 * Time: 02:00
 */

public interface PaymentRepository extends ReactiveMongoRepository<Payment, String> {

    Mono<PaymentResponseDTO> findByOrderId(String orderId);

    Flux<PaymentResponseDTO> findAllBy();

}