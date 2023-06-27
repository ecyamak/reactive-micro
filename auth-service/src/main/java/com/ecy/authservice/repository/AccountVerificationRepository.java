package com.ecy.authservice.repository;

import com.ecy.authservice.entity.AccountVerification;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

/**
 * Author: ecyamak
 * Date: 26.06.2023
 * Time: 21:33
 */

public interface AccountVerificationRepository extends ReactiveMongoRepository<AccountVerification, String> {

    Mono<AccountVerification> findByVerificationCode(String verificationCode);

}