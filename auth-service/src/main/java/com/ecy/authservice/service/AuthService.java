package com.ecy.authservice.service;

import com.ecy.authservice.dto.AccountDTO;
import com.ecy.authservice.entity.Account;
import com.ecy.authservice.entity.AccountVerification;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * Author: ecyamak
 * Date: 7.08.2023
 * Time: 20:13
 */

public interface AuthService {

    Mono<Map<String, String>> signin(AccountDTO accountDTO);

    Mono<Void> signup(AccountDTO accountDTO);

    Mono<Account> getAccount(Account account);

    Flux<Account> getAccounts();

    Mono<Account> updateAccount(Account account);

    Mono<Void> deleteAccount(Account account);

    Mono<Void> deleteAccounts();

    Mono<Boolean> verify(String verificationCode);

    Mono<AccountVerification> createVerification(AccountVerification accountVerification);

    Flux<AccountVerification> getVerifications();

    Mono<Void> deleteVerifications();

}