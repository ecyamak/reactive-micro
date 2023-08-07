package com.ecy.authservice.entity;

import com.ecy.authentication.reactive.jwt.Credentials;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * Author: ecyamak
 * Date: 27.06.2023
 * Time: 02:03
 */

@Data
@Builder
@Document
public class Account implements Credentials {

    @Id
    private String email;
    private String username;
    private String password;
    private Status status;
    private Set<String> roles;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

}