package com.ecy.authservice.service.impl;

import com.ecy.authservice.dto.AccountDTO;
import com.ecy.authservice.entity.Account;
import com.ecy.authservice.entity.AccountVerification;
import com.ecy.authservice.service.AccountService;
import com.ecy.authservice.service.AccountVerificationService;
import com.ecy.authservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * Author: ecyamak
 * Date: 7.08.2023
 * Time: 20:17
 */

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AccountService accountService;
    private final AccountVerificationService accountVerificationService;
    private final ModelMapper modelMapper;

    @Override
    public Mono<Map<String, String>> signin(AccountDTO accountDTO) {
        return accountService.authenticate(modelMapper.map(accountDTO, Account.class))
                .filter(r -> !r.isEmpty())
                .map(r -> Map.of("token", r));
    }

    @Override
    public Mono<Void> signup(AccountDTO accountDTO) {
        return accountService
                .create(modelMapper.map(accountDTO, Account.class))
                .flatMap(accountVerificationService::create)
                .then();
    }

    @Override
    public Mono<Account> getAccount(Account account) {
        return accountService.find(account);
    }

    @Override
    public Flux<Account> getAccounts() {
        return accountService.findAll();
    }

    @Override
    public Mono<Account> updateAccount(Account account) {
        return accountService.update(account);
    }

    @Override
    public Mono<Void> deleteAccount(Account account) {
        return accountService.delete(account);
    }

    @Override
    public Mono<Void> deleteAccounts() {
        return accountService.deleteAll();
    }

    @Override
    public Mono<Boolean> verify(String verificationCode) {
        return accountVerificationService.verify(verificationCode);
    }

    @Override
    public Mono<AccountVerification> createVerification(AccountVerification accountVerification) {
        return accountVerificationService.create(accountVerification);
    }

    @Override
    public Flux<AccountVerification> getVerifications() {
        return accountVerificationService.findAll();
    }

    @Override
    public Mono<Void> deleteVerifications() {
        return accountVerificationService.deleteAll();
    }

}