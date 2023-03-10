package com.ecy.firstservice.service.impl;

import com.ecy.firstservice.entities.FirstEntity;
import com.ecy.firstservice.repository.FirstRepository;
import com.ecy.firstservice.service.FirstService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class FirstServiceImpl implements FirstService {

    private final FirstRepository repository;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Mono<FirstEntity> get(String id) {
        return repository.findById(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Flux<FirstEntity> getAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Mono<FirstEntity> add(FirstEntity entity) {
        return repository.insert(entity);
    }

    @Override
    @Transactional
    public Mono<FirstEntity> update(FirstEntity entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional
    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }

    @Override
    @Transactional
    public Mono<Void> delete(FirstEntity entity) {
        return repository.delete(entity);
    }

    @Override
    @Transactional
    public Mono<Void> deleteAll() {
        return repository.deleteAll();
    }

}
