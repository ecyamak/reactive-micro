package com.ecy.notification.type;

import com.ecy.notification.Notification;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Author: ecyamak
 * Date: 26.06.2023
 * Time: 00:41
 */

public class Mail extends Notification {

    public Mail(@JsonProperty("to") String to,
                @JsonProperty("subject") String subject,
                @JsonProperty("message") String message) {
        super(to, subject, message);
    }

}