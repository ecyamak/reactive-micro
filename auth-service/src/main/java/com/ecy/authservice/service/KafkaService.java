package com.ecy.authservice.service;

import com.ecy.notification.Notification;
import reactor.core.publisher.Mono;

/**
 * Author: ecyamak
 * Date: 13.07.2023
 * Time: 03:37
 */
public interface KafkaService {

    Mono<Void> sendNotification(Notification notification);

}