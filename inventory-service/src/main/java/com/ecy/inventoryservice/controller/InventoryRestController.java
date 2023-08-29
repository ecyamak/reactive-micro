package com.ecy.inventoryservice.controller;

import com.ecy.inventoryservice.dto.InventoryRequestDTO;
import com.ecy.inventoryservice.dto.InventoryResponseDTO;
import com.ecy.inventoryservice.service.InventoryRestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Author: ecyamak
 * Date: 22.08.2023
 * Time: 02:17
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/inventory")
public class InventoryRestController {

    private final InventoryRestService inventoryRestService;

    @GetMapping("/info")
    public Mono<String> info() {
        return Mono.just("This is inventory service.");
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Void> create(@RequestBody InventoryRequestDTO inventoryRequestDTO) {
        return inventoryRestService.create(inventoryRequestDTO);
    }

    @GetMapping
    public Mono<InventoryResponseDTO> get(@RequestParam String productId) {
        return inventoryRestService.get(productId);
    }

    @GetMapping("/all")
    public Flux<InventoryResponseDTO> getAll() {
        return inventoryRestService.getAll();
    }

    @DeleteMapping
    public Mono<Void> delete(@RequestParam String productId) {
        return inventoryRestService.delete(productId);
    }

    @DeleteMapping("/all")
    public Mono<Void> deleteAll() {
        return inventoryRestService.deleteAll();
    }

}