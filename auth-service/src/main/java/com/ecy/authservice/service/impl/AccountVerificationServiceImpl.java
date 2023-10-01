package com.ecy.authservice.service.impl;

import com.ecy.authservice.entity.Account;
import com.ecy.authservice.entity.AccountVerification;
import com.ecy.authservice.repository.AccountVerificationRepository;
import com.ecy.authservice.service.AccountVerificationService;
import com.ecy.authservice.service.KafkaService;
import com.ecy.notification.NotificationFactory;
import com.ecy.notification.NotificationType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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
    private final KafkaService kafkaService;

    @Override
    public Mono<AccountVerification> create(Account account) {
        return create(AccountVerification.builder()
                .email(account.getEmail())
                .verificationCode(UUID.randomUUID().toString())
                .createDate(LocalDateTime.now())
                .expireDate(LocalDateTime.now().plusMinutes(15))
                .build())
                .doOnNext(accountVerification ->
                        kafkaService.sendNotification(NotificationFactory.get(NotificationType.MAIL,
                                accountVerification.getEmail(),
                                "Verification Code",
                                "http://localhost:8079/verify?verificationCode=" + accountVerification.getVerificationCode()))
                );
    }

    @Override
    public Mono<AccountVerification> create(AccountVerification accountVerification) {
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
                .delayUntil(this::create)
                .thenReturn(true);
    }

    @Override
    public Mono<Void> deleteAll() {
        return accountVerificationRepository.deleteAll();
    }

}