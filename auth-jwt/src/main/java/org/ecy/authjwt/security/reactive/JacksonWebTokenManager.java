package org.ecy.authjwt.security.reactive;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import reactor.core.publisher.Mono;

import java.security.Key;
import java.util.Date;
import java.util.Map;

public class JacksonWebTokenManager implements TokenManager {

    @Value("${token.secret}")
    private String secret;

    @Value("${token.expiration}")
    private Long expiration;

    private Key key;

    @PostConstruct
    public void init() {
        key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    @Override
    public Mono<String> generateToken(Credentials credentials) {
        return Mono.just(Jwts.builder()
                .setClaims(Map.of("role", credentials.getRoles()))
                .setSubject(credentials.getUsername())
                .setExpiration(new Date(new Date().getTime() + expiration))
                .setIssuedAt(new Date())
                .signWith(key)
                .compact());
    }

    @Override
    public Mono<Boolean> validateToken(String token) {
        Date expirationDate = getClaims(token).block().getExpiration();
        return Mono.just(!expirationDate.before(new Date()));
    }

    @Override
    public Mono<Claims> getClaims(String token) {
        return Mono.just(Jwts.parserBuilder()
                .setSigningKey(key).build()
                .parseClaimsJws(token).getBody());
    }

}
