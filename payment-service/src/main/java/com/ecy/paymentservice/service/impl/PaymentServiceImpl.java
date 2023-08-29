package com.ecy.paymentservice.service.impl;

import com.ecy.data.dto.PaymentDTO;
import com.ecy.paymentservice.model.Payment;
import com.ecy.paymentservice.repository.PaymentRepository;
import com.ecy.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * Author: ecyamak
 * Date: 28.08.2023
 * Time: 00:13
 */

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final ModelMapper modelMapper;

    @Override
    public Mono<Payment> receivePayment(PaymentDTO paymentDTO) {
        var payment = modelMapper.map(paymentDTO, Payment.class);
        return paymentRepository.save(payment);
    }

    @Override
    public Mono<Void> rejectPayment(String orderId) {
        return paymentRepository.findById(orderId)
                .doOnSuccess(payment -> paymentRepository.deleteById(payment.getOrderId()))
                .then();
    }

}