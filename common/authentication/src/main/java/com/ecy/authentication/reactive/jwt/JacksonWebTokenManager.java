package com.ecy.authentication.reactive.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;

import java.security.Key;
import java.util.Date;
import java.util.Map;

public class JacksonWebTokenManager implements TokenManager {

    @Value("${token.secret:dELhDB9aYDrjYvVTQ5nejB3PahyTvssEmHLL3a2tHtw7qBkwJmSx2jqGCrDAfZ6S}")
    private String secret;

    @Value("${token.expiration:100000}")
    private Long expiration;

    private Key key;

    @PostConstruct
    public void init() {
        key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    @Override
    public String generateToken(Credentials credentials) {
        return Jwts.builder()
                .setClaims(Map.of("role", credentials.getRoles()))
                .setSubject(credentials.getUsername())
                .setExpiration(new Date(new Date().getTime() + expiration))
                .setIssuedAt(new Date())
                .signWith(key)
                .compact();
    }

    @Override
    public Boolean validateToken(String token) {
        Date expirationDate = getClaims(token).getExpiration();
        return !expirationDate.before(new Date());
    }

    @Override
    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key).build()
                .parseClaimsJws(token).getBody();
    }

}