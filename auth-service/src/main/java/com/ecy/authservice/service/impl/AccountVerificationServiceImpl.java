package com.ecy.authservice.service.impl;

import com.ecy.authservice.entity.Account;
import com.ecy.authservice.entity.AccountVerification;
import com.ecy.authservice.repository.AccountVerificationRepository;
import com.ecy.authservice.service.AccountVerificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Author: ecyamak
 * Date: 26.06.2023
 * Time: 21:36
 */

@Service
@RequiredArgsConstructor
public class AccountVerificationServiceImpl implements AccountVerificationService {

    private final AccountVerificationRepository accountVerificationRepository;

    @Override
    public Mono<AccountVerification> create(Account account) {
        return save(AccountVerification.builder()
                .email(account.getEmail())
                .verificationCode(UUID.randomUUID().toString())
                .createDate(LocalDateTime.now())
                .expireDate(LocalDateTime.now().plusMinutes(15))
                .build());
    }

    @Override
    @Transactional
    public Mono<AccountVerification> save(AccountVerification accountVerification) {
        return accountVerificationRepository.save(accountVerification);
    }

    @Override
    public Flux<AccountVerification> findAll() {
        return accountVerificationRepository.findAll();
    }

    @Override
    public Mono<Boolean> verify(String verificationCode) {
        return accountVerificationRepository.findByVerificationCode(verificationCode)
                .filter(accountVerification -> accountVerification.getExpireDate().isAfter(LocalDateTime.now()))
                .doOnNext(accountVerification -> accountVerification.setConfirmDate(LocalDateTime.now()))
                .delayUntil(accountVerification -> save(accountVerification))
                .thenReturn(true);
    }

    @Override
    public Mono<Boolean> deleteAll() {
        return accountVerificationRepository.deleteAll().thenReturn(true);
    }

}