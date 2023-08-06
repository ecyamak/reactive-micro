package com.ecy.notification.type;

import com.ecy.notification.Notification;

/**
 * Author: ecyamak
 * Date: 5.08.2023
 * Time: 18:46
 */

public class SMS extends Notification {

    public SMS(String to, String subject, String message) {
        super(to, subject, message);
    }

}