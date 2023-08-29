package com.ecy.inventoryservice.repository;

import com.ecy.inventoryservice.dto.InventoryResponseDTO;
import com.ecy.inventoryservice.model.Inventory;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Author: ecyamak
 * Date: 22.08.2023
 * Time: 02:14
 */

public interface InventoryRepository extends ReactiveMongoRepository<Inventory, String> {

    Mono<InventoryResponseDTO> findByProductId(String productId);

    Flux<InventoryResponseDTO> findAllBy();

}