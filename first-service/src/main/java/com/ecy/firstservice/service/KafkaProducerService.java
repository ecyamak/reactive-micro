package com.ecy.firstservice.service;

/**
 * Author: ecyamak
 * Date: 2.04.2023
 * Time: 17:41
 */

public interface KafkaProducerService {

    void sendMessage(String message);

}