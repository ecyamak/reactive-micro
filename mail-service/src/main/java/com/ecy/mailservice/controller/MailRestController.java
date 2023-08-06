package com.ecy.mailservice.controller;

import com.ecy.mailservice.service.MailService;
import com.ecy.notification.type.Mail;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Author: ecyamak
 * Date: 25.06.2023
 * Time: 23:25
 */

@RestController
@AllArgsConstructor
@RequestMapping("/mail")
public class MailRestController {

    private final MailService mailService;

    @PostMapping("/send")
    public Mono<Void> send(@RequestBody Mail mail) {
        return mailService.send(mail);
    }

}