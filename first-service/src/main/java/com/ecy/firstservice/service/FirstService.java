package com.ecy.firstservice.service;

import com.ecy.firstservice.entities.FirstEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FirstService {

    Mono<FirstEntity> get(String id);
    Flux<FirstEntity> getAll();
    Mono<FirstEntity> add(FirstEntity entity);
    Mono<FirstEntity> update(FirstEntity entity);
    Mono<Void> delete(String id);
    Mono<Void> delete(FirstEntity entity);
    Mono<Void> deleteAll();

}
