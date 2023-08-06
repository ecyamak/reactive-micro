package com.ecy.authservice.service;

import com.ecy.notification.Notification;

/**
 * Author: ecyamak
 * Date: 13.07.2023
 * Time: 03:37
 */
public interface KafkaService {

    void sendNotification(Notification notification);

}