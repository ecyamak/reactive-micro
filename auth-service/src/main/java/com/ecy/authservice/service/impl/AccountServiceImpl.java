package com.ecy.authservice.service.impl;

import com.ecy.authservice.entity.Account;
import com.ecy.authservice.exception.AuthorizationException;
import com.ecy.authservice.repository.AccountRepository;
import com.ecy.authservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.ecy.authjwt.security.reactive.TokenManager;
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
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accountRepository.insert(account);
    }

    @Override
    public Mono<Account> find(Account account) {
        return !account.getEmail().isEmpty() ?
                accountRepository.findByEmail(account.getEmail()) :
                accountRepository.findByUsername(account.getUsername());
    }

    @Override
    public Flux<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    @Transactional
    public Mono<Account> update(Account account) {
        return accountRepository.save(account);
    }

    @Override
    @Transactional
    public Mono<Boolean> delete(Account account) {
        return accountRepository.delete(account).thenReturn(true);
    }

    @Override
    @Transactional
    public Mono<Boolean> deleteAll() {
        return accountRepository.deleteAll().thenReturn(true);
    }

    @Override
    public Mono<String> authenticate(Account account) {
        return find(account)
                .filter(a -> passwordEncoder.matches(account.getPassword(), a.getPassword()))
                .map(a -> tokenManager.generateToken(account).block())
                .switchIfEmpty(Mono.error(new AuthorizationException("401 Unauthorized")));
    }

}