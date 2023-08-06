package com.ecy.mailservice.service;


import com.ecy.notification.Notification;
import com.ecy.notification.NotificationService;
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
public class MailService implements NotificationService {

    private final JavaMailSender mailSender;

    @Value("${mail.username:null}")
    private String sender;

    @Override
    public Mono<Void> send(Notification notification) {
        return sendMail(notification.getTo(), notification.getSubject(), notification.getMessage());
    }

    private Mono<Void> sendMail(String to, String subject, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(sender);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
        mailSender.send(simpleMailMessage);
        return Mono.empty();
    }

}