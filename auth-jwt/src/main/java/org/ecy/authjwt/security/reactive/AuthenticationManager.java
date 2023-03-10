package org.ecy.authjwt.security.reactive;

import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class AuthenticationManager implements ReactiveAuthenticationManager {

    private final TokenManager tokenManager;

    public Mono<Authentication> authenticate(Authentication authentication) {
        String token = authentication.getCredentials().toString();
        return Mono.just(tokenManager.validateToken(token))
                .filter(valid -> valid.block())
                .switchIfEmpty(Mono.empty())
                .map(valid -> {
                    Claims claims = tokenManager.getClaims(token).block();
                    List<String> roleList = claims.get("role", List.class);
                    return new UsernamePasswordAuthenticationToken(
                            claims.getSubject(),
                            null,
                            roleList.stream()
                                    .map(SimpleGrantedAuthority::new)
                                    .collect(Collectors.toList())
                    );
                });
    }

}
