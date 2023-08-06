package com.ecy.notification;

import lombok.*;

/**
 * Author: ecyamak
 * Date: 5.08.2023
 * Time: 18:33
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Notification {

    private String to;
    private String subject;
    private String message;

}