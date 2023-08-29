package com.ecy.paymentservice.service;

import com.ecy.data.dto.PaymentDTO;
import com.ecy.paymentservice.model.Payment;
import reactor.core.publisher.Mono;

/**
 * Author: ecyamak
 * Date: 28.08.2023
 * Time: 00:13
 */

public interface PaymentService {

    Mono<Payment> receivePayment(PaymentDTO paymentDTO);

    Mono<Void> rejectPayment(String orderId);

}