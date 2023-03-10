package com.ecy.secondservice.controller;

import com.ecy.secondservice.entity.SecondEntity;
import com.ecy.secondservice.service.SecondService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/second")
public class SecondRestController {

    private final SecondService service;

    @GetMapping
    public Mono<String> info() {
        return Mono.just("This is second service.");
    }

    @GetMapping("/{id}")
    public Mono<SecondEntity> get(@PathVariable("id") String id) {
        return service.get(id);
    }

    @GetMapping("/all")
    public Flux<SecondEntity> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Mono<SecondEntity> post(@RequestBody SecondEntity entity) {
        return service.add(entity);
    }

    @PutMapping
    public Mono<SecondEntity> put(@RequestBody SecondEntity entity) {
        return service.update(entity);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@RequestParam("id") String id) {
        return service.delete(id);
    }

    @DeleteMapping
    public Mono<Void> delete(@RequestBody SecondEntity entity) {
        return service.delete(entity);
    }

    @DeleteMapping("/all")
    public Mono<Void> deleteAll() {
        return service.deleteAll();
    }

}
