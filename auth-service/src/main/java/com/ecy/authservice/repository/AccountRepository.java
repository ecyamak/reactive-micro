package com.ecy.authservice.repository;

import com.ecy.authservice.entity.Account;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Author: ecyamak
 * Date: 27.06.2023
 * Time: 03:36
 */

public interface AccountRepository extends ReactiveMongoRepository<Account, String> {

    Mono<Account> findByEmail(String email);

    Mono<Account> findByUsername(String username);

    Flux<Account> findAllBy(Pageable pageable);

}