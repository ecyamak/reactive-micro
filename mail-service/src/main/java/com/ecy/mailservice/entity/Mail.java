package com.ecy.mailservice.entity;

import lombok.Data;

/**
 * Author: ecyamak
 * Date: 26.06.2023
 * Time: 00:41
 */

@Data
public class Mail {

    private String to;
    private String subject;
    private String message;

}