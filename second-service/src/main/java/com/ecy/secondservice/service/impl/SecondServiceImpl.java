package com.ecy.secondservice.service.impl;

import com.ecy.secondservice.entity.SecondEntity;
import com.ecy.secondservice.repository.SecondRespository;
import com.ecy.secondservice.service.SecondService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class SecondServiceImpl implements SecondService {

    private final SecondRespository respository;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Mono<SecondEntity> get(String id) {
        return respository.findById(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Flux<SecondEntity> getAll() {
        return respository.findAll();
    }

    @Override
    @Transactional
    public Mono<SecondEntity> add(SecondEntity entity) {
        return respository.insert(entity);
    }

    @Override
    @Transactional
    public Mono<SecondEntity> update(SecondEntity entity) {
        return respository.save(entity);
    }

    @Override
    @Transactional
    public Mono<Void> delete(String id) {
        return respository.deleteById(id);
    }

    @Override
    @Transactional
    public Mono<Void> delete(SecondEntity entity) {
        return respository.delete(entity);
    }

    @Override
    @Transactional
    public Mono<Void> deleteAll() {
        return deleteAll();
    }
}
