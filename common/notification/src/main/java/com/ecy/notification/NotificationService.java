package com.ecy.notification;

import reactor.core.publisher.Mono;

/**
 * Author: ecyamak
 * Date: 5.08.2023
 * Time: 19:35
 */

public interface NotificationService {

    Mono<Void> send(Notification notification);

}