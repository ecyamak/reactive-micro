package com.ecy.orderservice.configuration;

import com.ecy.data.event.InventoryEvent;
import com.ecy.data.event.PaymentEvent;
import com.ecy.orderservice.manager.OrderEventManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

/**
 * Author: ecyamak
 * Date: 28.08.2023
 * Time: 00:29
 */

@Configuration
@RequiredArgsConstructor
public class OrderEventConfiguration {

    private final OrderEventManager orderEventManager;

    @Bean
    public Consumer<PaymentEvent> paymentEventConsumer() {
        return paymentEvent ->
                orderEventManager.updateOrder(paymentEvent.getPaymentDTO().getOrderId(),
                        order -> order.setPaymentStatus(paymentEvent.getPaymentStatus()));
    }

    @Bean
    public Consumer<InventoryEvent> inventoryEventConsumer() {
        return inventoryEvent ->
            orderEventManager.updateOrder(inventoryEvent.getInventoryDTO().getOrderId(),
                    order -> order.setInventoryStatus(inventoryEvent.getInventoryStatus()));
    }

}