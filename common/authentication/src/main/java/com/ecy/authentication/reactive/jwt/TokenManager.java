package com.ecy.authentication.reactive.jwt;

import io.jsonwebtoken.Claims;
import reactor.core.publisher.Mono;

public interface TokenManager {

    Mono<String> generateToken(Credentials credentials);

    Mono<Boolean> validateToken(String token);

    Mono<Claims> getClaims(String token);

}