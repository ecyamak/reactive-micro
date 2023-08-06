package com.ecy.authservice.entity;

import com.ecy.authentication.reactive.jwt.Credentials;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Builder
@Document
public class User implements Credentials {

    @Id
    private String username;
    private String password;
    private Set<String> roles;

}