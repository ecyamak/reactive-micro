package com.ecy.inventoryservice.service.impl;

import com.ecy.data.dto.InventoryDTO;
import com.ecy.inventoryservice.exception.OutOfStockException;
import com.ecy.inventoryservice.model.Inventory;
import com.ecy.inventoryservice.repository.InventoryRepository;
import com.ecy.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * Author: ecyamak
 * Date: 22.08.2023
 * Time: 02:15
 */

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Override
    public Mono<Inventory> increaseStock(InventoryDTO inventoryDTO) {
        return inventoryRepository.findById(inventoryDTO.getProductId())
                .map(inventory -> {
                    inventory.setStock(inventory.getStock() + inventoryDTO.getAmount());
                    inventoryRepository.save(inventory);
                    return inventory;
                });
    }

    @Override
    public Mono<Inventory> reduceStock(InventoryDTO inventoryDTO) {
        return inventoryRepository.findById(inventoryDTO.getProductId())
                .filter(inventory -> inventory.getStock() > inventoryDTO.getAmount())
                .flatMap(inventory -> {
                    inventory.setStock(inventory.getStock() - inventoryDTO.getAmount());
                    return inventoryRepository.save(inventory);
                })
                .switchIfEmpty(Mono.error(new OutOfStockException("Insufficient stock")));
    }

}