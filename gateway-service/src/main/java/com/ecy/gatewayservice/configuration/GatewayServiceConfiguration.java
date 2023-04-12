package com.ecy.gatewayservice.configuration;

import org.ecy.authjwt.security.reactive.AuthenticationManager;
import org.ecy.authjwt.security.reactive.JacksonWebTokenManager;
import org.ecy.authjwt.security.reactive.SecurityContextRepository;
import org.ecy.authjwt.security.reactive.TokenManager;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.context.ServerSecurityContextRepository;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
@EnableWebFluxSecurity
public class GatewayServiceConfiguration {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r
                        .path("/signin", "/signup", "/all", "/resource")
                        .uri("lb://auth-service"))
                .route(r -> r
                        .path("/first/**")
                        .uri("lb://first-service"))
                .route(r -> r
                        .path("/second/**")
                        .uri("lb://second-service"))
                .build();
    }

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
                .csrf().disable()
                .cors().configurationSource(source -> {
                    CorsConfiguration configuration = new CorsConfiguration();
                    configuration.setAllowedOrigins(List.of("http://localhost:4200"));
                    configuration.setAllowedMethods(List.of("*"));
                    configuration.setAllowedHeaders(List.of("*"));
                    return configuration;
                }).and()
                .authenticationManager(authenticationManager())
                .securityContextRepository(securityContextRepository())
                .formLogin().disable()
                .authorizeExchange()
                .pathMatchers("/signin", "/signup", "/all").permitAll()
                .anyExchange().authenticated().and()
                .build();
    }

    @Bean
    public TokenManager tokenManager() {
        return new JacksonWebTokenManager();
    }

    @Bean
    public ReactiveAuthenticationManager authenticationManager() {
        return new AuthenticationManager(tokenManager());
    }

    @Bean
    public ServerSecurityContextRepository securityContextRepository() {
        return new SecurityContextRepository(authenticationManager());
    }

}