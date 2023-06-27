package com.ecy.authservice.service;

import com.ecy.authservice.entity.Account;
import com.ecy.authservice.entity.AccountVerification;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Author: ecyamak
 * Date: 26.06.2023
 * Time: 21:34
 */

public interface AccountVerificationService {

    Mono<AccountVerification> create(Account account);

    Mono<AccountVerification> save(AccountVerification accountVerification);

    Flux<AccountVerification> findAll();

    Mono<Boolean> verify(String verificationCode);

    Mono<Boolean> deleteAll();

}