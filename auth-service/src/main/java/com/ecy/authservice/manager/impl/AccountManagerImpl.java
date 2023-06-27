package com.ecy.authservice.manager.impl;

import com.ecy.authservice.entity.Account;
import com.ecy.authservice.entity.AccountVerification;
import com.ecy.authservice.manager.AccountManager;
import com.ecy.authservice.service.AccountService;
import com.ecy.authservice.service.AccountVerificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Author: ecyamak
 * Date: 27.06.2023
 * Time: 06:08
 */

@Service
@RequiredArgsConstructor
public class AccountManagerImpl implements AccountManager {

    private final AccountService accountService;
    private final AccountVerificationService accountVerificationService;

    @Override
    public Mono<Void> createAccount(Account account) {
        return accountService.create(account)
                .and(accountVerificationService.create(account));
    }

    @Override
    public Mono<Boolean> verifyAccount(String verificationCode) {
        return accountVerificationService.verify(verificationCode);
    }

    @Override
    public Flux<Account> getAllAccounts() {
        return accountService.findAll();
    }

    @Override
    public Mono<Boolean> deleteAllAccounts() {
        return accountService.deleteAll();
    }

    @Override
    public Flux<AccountVerification> getAllVerifications() {
        return accountVerificationService.findAll();
    }

    @Override
    public Mono<Boolean> deleteAllVerifications() {
        return accountVerificationService.deleteAll();
    }

}