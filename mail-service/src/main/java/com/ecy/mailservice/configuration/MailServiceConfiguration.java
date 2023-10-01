package com.ecy.mailservice.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * Author: ecyamak
 * Date: 6.08.2023
 * Time: 01:28
 */

@Configuration
public class MailServiceConfiguration {

    @Bean
    public JavaMailSender mailSender(@Value("${spring.mail.host:null}") String host,
                                     @Value("${spring.mail.port:587}") String port,
                                     @Value("${spring.mail.username:null}") String username,
                                     @Value("${spring.mail.password:null}") String password) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setPort(Integer.valueOf(port));
        mailSender.setUsername(username);
        mailSender.setPassword(password);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        return mailSender;
    }

}