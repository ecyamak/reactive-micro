package com.ecy.mailservice.listener;

import com.ecy.mailservice.service.MailService;
import com.ecy.notification.type.Mail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Author: ecyamak
 * Date: 13.07.2023
 * Time: 06:56
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class MailServiceListener {

    private final MailService mailService;

    @KafkaListener(topics = "auth-topic", groupId = "mail-group")
    public void listen(Mail mail) {
        mailService.send(mail);
    }

}