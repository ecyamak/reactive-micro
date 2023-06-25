package com.ecy.mailservice.service;

import com.ecy.mailservice.entity.Mail;
import reactor.core.publisher.Mono;

/**
 * Author: ecyamak
 * Date: 25.06.2023
 * Time: 23:14
 */
public interface MailService {

    Mono<Void> sendMail(Mail mail);

    Mono<Void> sendMail(String to, String subject, String text);

}