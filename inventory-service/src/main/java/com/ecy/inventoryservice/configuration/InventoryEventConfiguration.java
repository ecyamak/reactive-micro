package com.ecy.inventoryservice.configuration;

import com.ecy.data.enums.OrderStatus;
import com.ecy.data.event.InventoryEvent;
import com.ecy.data.event.OrderEvent;
import com.ecy.inventoryservice.manager.InventoryEventManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

/**
 * Author: ecyamak
 * Date: 27.08.2023
 * Time: 15:52
 */

@Configuration
@RequiredArgsConstructor
public class InventoryEventConfiguration {

    private final InventoryEventManager inventoryEventManager;

    @Bean
    public Function<Flux<OrderEvent>, Flux<InventoryEvent>> inventoryProcessor() {
        return orderEventFlux -> orderEventFlux.flatMap(this::processInventory);
    }

    private Mono<InventoryEvent> processInventory(OrderEvent orderEvent) {
        if (orderEvent.getOrderStatus().equals(OrderStatus.RECEIVED))
            return inventoryEventManager.receiveOrder(orderEvent);
        return Mono.fromRunnable(() -> inventoryEventManager.rejectOrder(orderEvent));
    }

}