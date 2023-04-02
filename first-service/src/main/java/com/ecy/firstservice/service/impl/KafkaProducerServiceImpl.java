package com.ecy.firstservice.service.impl;

import com.ecy.firstservice.service.KafkaProducerService;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Author: ecyamak
 * Date: 2.04.2023
 * Time: 17:42
 */

@Service
@AllArgsConstructor
public class KafkaProducerServiceImpl implements KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendMessage(String message) {
        kafkaTemplate.send("first-topic", message);
    }

}