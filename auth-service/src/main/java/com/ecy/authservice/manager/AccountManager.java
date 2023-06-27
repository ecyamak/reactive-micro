package com.ecy.authservice.manager;

import com.ecy.authservice.entity.Account;
import com.ecy.authservice.entity.AccountVerification;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Author: ecyamak
 * Date: 27.06.2023
 * Time: 19:33
 */

public interface AccountManager {

    Mono<Void> createAccount(Account account);

    Mono<Boolean> verifyAccount(String verificationCode);

    Flux<Account> getAllAccounts();

    Mono<Boolean> deleteAllAccounts();

    Flux<AccountVerification> getAllVerifications();

    Mono<Boolean> deleteAllVerifications();

}