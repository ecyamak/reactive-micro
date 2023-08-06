package com.ecy.authentication.reactive.jwt;

import java.util.Set;

public interface Credentials {

    String getUsername();
    String getPassword();
    Set<String> getRoles();

}