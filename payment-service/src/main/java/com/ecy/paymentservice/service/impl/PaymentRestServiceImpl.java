package com.ecy.paymentservice.service.impl;

import com.ecy.paymentservice.dto.PaymentRequestDTO;
import com.ecy.paymentservice.dto.PaymentResponseDTO;
import com.ecy.paymentservice.model.Payment;
import com.ecy.paymentservice.repository.PaymentRepository;
import com.ecy.paymentservice.service.PaymentRestService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Author: ecyamak
 * Date: 22.08.2023
 * Time: 02:02
 */

@Service
@RequiredArgsConstructor
public class PaymentRestServiceImpl implements PaymentRestService {

    private final PaymentRepository paymentRepository;
    private final ModelMapper modelMapper;

    @Override
    public Mono<Void> create(PaymentRequestDTO paymentRequestDTO) {
        var payment = modelMapper.map(paymentRequestDTO, Payment.class);
        return Mono.when(paymentRepository.save(payment));
    }

    @Override
    public Mono<PaymentResponseDTO> get(String orderId) {
        return paymentRepository.findByOrderId(orderId);
    }

    @Override
    public Flux<PaymentResponseDTO> getAll() {
        return paymentRepository.findAllBy();
    }

    @Override
    public Mono<Void> delete(String paymentId) {
        return paymentRepository.deleteById(paymentId);
    }

    @Override
    public Mono<Void> deleteAll() {
        return paymentRepository.deleteAll();
    }

}