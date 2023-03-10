package com.ecy.secondservice.service;

import com.ecy.secondservice.entity.SecondEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SecondService {

    Mono<SecondEntity> get(String id);
    Flux<SecondEntity> getAll();
    Mono<SecondEntity> add(SecondEntity entity);
    Mono<SecondEntity> update(SecondEntity entity);
    Mono<Void> delete(String id);
    Mono<Void> delete(SecondEntity entity);
    Mono<Void> deleteAll();
}
