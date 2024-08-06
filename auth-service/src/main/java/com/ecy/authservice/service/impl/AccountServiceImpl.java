package com.ecy.authservice.service.impl;

import com.ecy.authentication.reactive.jwt.TokenManager;
import com.ecy.authservice.entity.Account;
import com.ecy.authservice.exception.AuthenticationException;
import com.ecy.authservice.repository.AccountRepository;
import com.ecy.authservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Author: ecyamak
 * Date: 27.06.2023
 * Time: 03:47
 */

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenManager tokenManager;

    @Override
    @Transactional
    public Mono<Account> create(Account account) {
        return Mono
                .fromRunnable(() -> account.setPassword(passwordEncoder.encode(account.getPassword())))
                .then(accountRepository.insert(account));
    }

    @Override
    public Mono<Account> find(Account account) {
        return accountRepository.findByUsername(account.getUsername());
    }

    @Override
    public Flux<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Mono<Page<Account>> findAll(Pageable pageable) {
        return accountRepository.findAllBy(pageable)
                .collectList()
                .zipWith(accountRepository.count())
                .map(tuple -> new PageImpl<>(tuple.getT1(), pageable, tuple.getT2()));
    }

    @Override
    @Transactional
    public Mono<Account> update(Account account) {
        return accountRepository.save(account);
    }

    @Override
    @Transactional
    public Mono<Void> delete(Account account) {
        return accountRepository.delete(account);
    }

    @Override
    @Transactional
    public Mono<Void> deleteAll() {
        return accountRepository.deleteAll();
    }

    @Override
    public Mono<String> authenticate(Account account) {
        return find(account)
                .filter(acc -> passwordEncoder.matches(account.getPassword(), acc.getPassword()))
                .map(tokenManager::generateToken)
                .switchIfEmpty(Mono.error(new AuthenticationException("Not Authenticated")));
    }

}