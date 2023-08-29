package com.ecy.paymentservice.configuration;

import com.ecy.data.enums.OrderStatus;
import com.ecy.data.event.OrderEvent;
import com.ecy.data.event.PaymentEvent;
import com.ecy.paymentservice.manager.PaymentEventManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

/**
 * Author: ecyamak
 * Date: 27.08.2023
 * Time: 23:31
 */

@Configuration
@RequiredArgsConstructor
public class PaymentEventConfiguration {

    private final PaymentEventManager paymentEventManager;

    @Bean
    public Function<Flux<OrderEvent>, Flux<PaymentEvent>> paymentProcessor() {
        return orderEventFlux -> orderEventFlux.flatMap(this::processPayment);
    }

    private Mono<PaymentEvent> processPayment(OrderEvent orderEvent) {
        if (orderEvent.getOrderStatus().equals(OrderStatus.RECEIVED))
            return paymentEventManager.receiveOrder(orderEvent);
        return Mono.fromRunnable(() -> paymentEventManager.cancelOrder(orderEvent));
    }

}