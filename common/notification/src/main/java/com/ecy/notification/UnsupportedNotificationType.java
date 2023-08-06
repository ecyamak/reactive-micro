package com.ecy.notification;

/**
 * Author: ecyamak
 * Date: 5.08.2023
 * Time: 19:58
 */

public class UnsupportedNotificationType extends RuntimeException {

    public UnsupportedNotificationType(String message) {
        super(message);
    }

}