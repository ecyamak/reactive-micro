package com.ecy.paymentservice.manager.impl;

import com.ecy.data.dto.PaymentDTO;
import com.ecy.data.enums.PaymentStatus;
import com.ecy.data.event.OrderEvent;
import com.ecy.data.event.PaymentEvent;
import com.ecy.paymentservice.manager.PaymentEventManager;
import com.ecy.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * Author: ecyamak
 * Date: 23.08.2023
 * Time: 02:04
 */

@Component
@RequiredArgsConstructor
public class PaymentEventManagerImpl implements PaymentEventManager {

    private final PaymentService paymentService;

    @Override
    public Mono<PaymentEvent> receiveOrder(OrderEvent orderEvent) {
        var orderDTO = orderEvent.getOrderDTO();
        var paymentDTO = PaymentDTO.builder()
                .orderId(orderDTO.getOrderId())
                .userId(orderDTO.getUserId())
                .amount(orderDTO.getAmount())
                .build();
        return paymentService.receivePayment(paymentDTO)
                .thenReturn(PaymentEvent.of(paymentDTO, PaymentStatus.RECEIVED))
                .onErrorReturn(PaymentEvent.of(paymentDTO, PaymentStatus.REJECTED));
    }

    @Override
    public Mono<Void> cancelOrder(OrderEvent orderEvent) {
        var orderDTO = orderEvent.getOrderDTO();
        return paymentService.rejectPayment(orderDTO.getOrderId());
    }

}