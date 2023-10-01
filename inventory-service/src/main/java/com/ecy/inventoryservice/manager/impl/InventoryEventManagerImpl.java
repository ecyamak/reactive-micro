package com.ecy.inventoryservice.manager.impl;

import com.ecy.data.dto.InventoryDTO;
import com.ecy.data.enums.InventoryStatus;
import com.ecy.data.event.InventoryEvent;
import com.ecy.data.event.OrderEvent;
import com.ecy.inventoryservice.manager.InventoryEventManager;
import com.ecy.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * Author: ecyamak
 * Date: 24.08.2023
 * Time: 20:27
 */

@Component
@RequiredArgsConstructor
public class InventoryEventManagerImpl implements InventoryEventManager {

    private final InventoryService inventoryService;

    @Override
    public Mono<InventoryEvent> receiveOrder(OrderEvent orderEvent) {
        var orderDTO = orderEvent.getOrderDTO();
        var inventoryDTO = InventoryDTO.builder()
                .orderId(orderDTO.getOrderId())
                .productId(orderDTO.getProductId())
                .amount(orderDTO.getAmount())
                .build();
        return inventoryService.reduceStock(inventoryDTO)
                .thenReturn(InventoryEvent.of(inventoryDTO, InventoryStatus.RECEIVED))
                .onErrorReturn(InventoryEvent.of(inventoryDTO, InventoryStatus.REJECTED));
    }

    @Override
    public Mono<Void> rejectOrder(OrderEvent orderEvent) {
        var orderDTO = orderEvent.getOrderDTO();
        var inventoryDTO = InventoryDTO.builder()
                .productId(orderDTO.getProductId())
                .amount(orderDTO.getAmount())
                .build();
        return inventoryService.increaseStock(inventoryDTO).then();
    }

}