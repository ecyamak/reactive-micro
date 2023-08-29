package com.ecy.inventoryservice.service;

import com.ecy.inventoryservice.dto.InventoryRequestDTO;
import com.ecy.inventoryservice.dto.InventoryResponseDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Author: ecyamak
 * Date: 27.08.2023
 * Time: 22:05
 */

public interface InventoryRestService {

    Mono<Void> create(InventoryRequestDTO inventoryRequestDTO);

    Mono<InventoryResponseDTO> get(String productId);

    Flux<InventoryResponseDTO> getAll();

    Mono<Void> delete(String productId);

    Mono<Void> deleteAll();

}