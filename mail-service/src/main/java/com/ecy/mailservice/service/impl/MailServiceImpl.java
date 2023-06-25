package com.ecy.mailservice.service.impl;

import com.ecy.mailservice.entity.Mail;
import com.ecy.mailservice.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * Author: ecyamak
 * Date: 25.06.2023
 * Time: 23:17
 */
@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final JavaMailSender mailSender;

    @Value("${mail.username}")
    private String sender;

    @Override
    public Mono<Void> sendMail(Mail mail) {
        return sendMail(mail.getTo(), mail.getSubject(), mail.getMessage());
    }

    @Override
    public Mono<Void> sendMail(String to, String subject, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(sender);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
        mailSender.send(simpleMailMessage);
        return Mono.empty();
    }

}