package com.ecy.inventoryservice.service;

import com.ecy.data.dto.InventoryDTO;
import com.ecy.inventoryservice.model.Inventory;
import reactor.core.publisher.Mono;

/**
 * Author: ecyamak
 * Date: 22.08.2023
 * Time: 02:15
 */

public interface InventoryService {

    Mono<Inventory> increaseStock(InventoryDTO inventoryDTO);

    Mono<Inventory> reduceStock(InventoryDTO inventoryDTO);

}