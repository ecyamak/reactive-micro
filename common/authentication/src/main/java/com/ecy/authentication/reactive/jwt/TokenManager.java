package com.ecy.authentication.reactive.jwt;

import io.jsonwebtoken.Claims;

public interface TokenManager {

    String generateToken(Credentials credentials);

    Boolean validateToken(String token);

    Claims getClaims(String token);

}