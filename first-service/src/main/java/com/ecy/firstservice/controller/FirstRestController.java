package com.ecy.firstservice.controller;

import com.ecy.firstservice.entities.FirstEntity;
import com.ecy.firstservice.service.FirstService;
import com.ecy.firstservice.service.KafkaProducerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/first")
public class FirstRestController {

    private final FirstService service;
    private final KafkaProducerService kafkaProducerService;
    private final WebClient.Builder webClientBuilder;

    @GetMapping
    public Mono<Object> info() {
        return Mono.just("This is first service.");
    }

    @GetMapping("/second")
    public Mono<String> secondInfo() {
        return webClientBuilder.build()
                .get().uri("lb://second-service/second")
                .retrieve()
                .bodyToMono(String.class);
    }

    @PostMapping("/kafka")
    public Mono<Void> kafka() {
        kafkaProducerService.sendMessage("test message");
        return Mono.empty();
    }

    @GetMapping("/{id}")
    public Mono<FirstEntity> get(@PathVariable("id") String id) {
        return service.get(id);
    }

    @GetMapping("/all")
    public Flux<FirstEntity> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Mono<FirstEntity> post(@RequestBody FirstEntity entity) {
        return service.add(entity);
    }

    @PutMapping
    public Mono<FirstEntity> put(@RequestBody FirstEntity entity) {
        return service.update(entity);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

    @DeleteMapping
    public Mono<Void> delete(@RequestBody FirstEntity entity) {
        return service.delete(entity);
    }

    @DeleteMapping("/all")
    public Mono<Void> deleteAll() {
        return service.deleteAll();
    }

}