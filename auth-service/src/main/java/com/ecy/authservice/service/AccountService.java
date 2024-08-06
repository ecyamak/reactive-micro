package com.ecy.authservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.ecy.authservice.entity.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Author: ecyamak
 * Date: 27.06.2023
 * Time: 03:39
 */
public interface AccountService {

    Mono<Account> create(Account account);

    Mono<Account> find(Account account);

    Flux<Account> findAll();

    Mono<Page<Account>> findAll(Pageable pageable);

    Mono<Account> update(Account account);

    Mono<Void> delete(Account account);

    Mono<Void> deleteAll();

    Mono<String> authenticate(Account account);

}