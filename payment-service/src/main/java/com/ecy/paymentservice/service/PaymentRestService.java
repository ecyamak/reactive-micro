package com.ecy.paymentservice.service;

import com.ecy.paymentservice.dto.PaymentRequestDTO;
import com.ecy.paymentservice.dto.PaymentResponseDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Author: ecyamak
 * Date: 22.08.2023
 * Time: 02:02
 */
public interface PaymentRestService {

    Mono<Void> create(PaymentRequestDTO paymentRequestDTO);

    Mono<PaymentResponseDTO> get(String orderId);

    Flux<PaymentResponseDTO> getAll();

    Mono<Void> delete(String orderId);

    Mono<Void> deleteAll();

}