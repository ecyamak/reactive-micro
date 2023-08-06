package com.ecy.notification.type;

import com.ecy.notification.Notification;

/**
 * Author: ecyamak
 * Date: 5.08.2023
 * Time: 18:47
 */

public class PushNotification extends Notification {

    public PushNotification(String to, String subject, String message) {
        super(to, subject, message);
    }

}