package com.ecy.secondservice.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Author: ecyamak
 * Date: 2.04.2023
 * Time: 18:36
 */

@Slf4j
@Component
public class KafkaConsumerListener {

    @KafkaListener(topics = "first-topic", groupId = "consumer-group")
    public void listen(String message) {
      log.info("Received message: " + message);
    }

}