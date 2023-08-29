package com.ecy.inventoryservice.service.impl;

import com.ecy.data.service.mongo.AbstractBaseService;
import com.ecy.inventoryservice.dto.InventoryRequestDTO;
import com.ecy.inventoryservice.dto.InventoryResponseDTO;
import com.ecy.inventoryservice.model.Inventory;
import com.ecy.inventoryservice.repository.InventoryRepository;
import com.ecy.inventoryservice.service.InventoryRestService;
import org.modelmapper.ModelMapper;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Author: ecyamak
 * Date: 27.08.2023
 * Time: 22:05
 */

@Service
public class InventoryRestServiceImpl extends AbstractBaseService implements InventoryRestService {

    private final InventoryRepository inventoryRepository;
    private final ModelMapper modelMapper;

    public InventoryRestServiceImpl(ReactiveMongoTemplate reactiveMongoTemplate,
                                    InventoryRepository inventoryRepository,
                                    ModelMapper modelMapper) {
        super(reactiveMongoTemplate);
        this.inventoryRepository = inventoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Mono<Void> create(InventoryRequestDTO inventoryRequestDTO) {
        var inventory = modelMapper.map(inventoryRequestDTO, Inventory.class);
        return Mono.when(inventoryRepository.save(inventory));
    }

    @Override
    public Mono<InventoryResponseDTO> get(String productId) {
        return inventoryRepository.findByProductId(productId);
    }

    @Override
    public Flux<InventoryResponseDTO> getAll() {
        return inventoryRepository.findAllBy();
    }

    @Override
    public Mono<Void> delete(String productId) {
        return inventoryRepository.deleteById(productId);
    }

    @Override
    public Mono<Void> deleteAll() {
        return inventoryRepository.deleteAll();
    }

}