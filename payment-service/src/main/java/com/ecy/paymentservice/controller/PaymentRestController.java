package com.ecy.paymentservice.controller;

import com.ecy.paymentservice.dto.PaymentRequestDTO;
import com.ecy.paymentservice.dto.PaymentResponseDTO;
import com.ecy.paymentservice.service.PaymentRestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Author: ecyamak
 * Date: 22.08.2023
 * Time: 02:07
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")
public class PaymentRestController {

    private final PaymentRestService paymentRestService;

    @GetMapping("/info")
    public Mono<String> info() {
        return Mono.just("This is payment service.");
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Void> create(@RequestBody PaymentRequestDTO paymentRequestDTO) {
        return paymentRestService.create(paymentRequestDTO);
    }

    @GetMapping
    public Mono<PaymentResponseDTO> get(@RequestParam String orderId) {
        return paymentRestService.get(orderId);
    }

    @GetMapping("/all")
    public Flux<PaymentResponseDTO> getAll() {
        return paymentRestService.getAll();
    }

    @DeleteMapping
    public Mono<Void> delete(@RequestParam String orderId) {
        return paymentRestService.delete(orderId);
    }

    @DeleteMapping("/all")
    public Mono<Void> deleteAll() {
        return paymentRestService.deleteAll();
    }

}