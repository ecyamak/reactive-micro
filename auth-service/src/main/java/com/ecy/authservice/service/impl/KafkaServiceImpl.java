package com.ecy.authservice.service.impl;

import com.ecy.authservice.service.KafkaService;
import com.ecy.notification.Notification;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Author: ecyamak
 * Date: 13.07.2023
 * Time: 03:39
 */

@Service
@RequiredArgsConstructor
public class KafkaServiceImpl implements KafkaService {

    private final KafkaTemplate<String, Notification> kafkaTemplate;

    @Override
    public void sendNotification(Notification notification) {
        kafkaTemplate.send("auth-topic", notification);
    }

}