package com.ecy.authservice.dto;

import com.ecy.authservice.entity.Status;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * Author: ecyamak
 * Date: 7.08.2023
 * Time: 22:20
 */

@Data
public class AccountDTO {

    private String email;
    private String username;
    private String password;
    private Status status;
    private Set<String> roles;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

}