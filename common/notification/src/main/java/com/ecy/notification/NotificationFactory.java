package com.ecy.notification;

import com.ecy.notification.type.Mail;
import com.ecy.notification.type.PushNotification;
import com.ecy.notification.type.SMS;

/**
 * Author: ecyamak
 * Date: 5.08.2023
 * Time: 18:51
 */

public class NotificationFactory {

    public static Notification get(NotificationType notificationType, String to, String subject, String message) {
        switch (notificationType) {
            case MAIL: return new Mail(to, subject, message);
            case SMS: return new SMS(to, subject, message);
            case PUSH: return new PushNotification(to, subject, message);
            default: throw new UnsupportedNotificationType("Unsupported notification type");
        }
    }

}