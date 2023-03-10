package com.ecy.authservice.service;

import com.ecy.authservice.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<User> save(User user);

    Mono<User> get(User user);

    Flux<User> getAll();

    Mono<String> authenticate(User user);

    Mono<Void> deleteAll();

}
