package com.ecy.authservice.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Author: ecyamak
 * Date: 26.06.2023
 * Time: 21:12
 */

@Data
@Builder
@Document
public class AccountVerification implements Serializable {

    @Id
    private String email;
    private String verificationCode;
    private LocalDateTime createDate;
    private LocalDateTime expireDate;
    private LocalDateTime confirmDate;

}