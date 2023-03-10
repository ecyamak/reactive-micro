package com.ecy.authservice.configuration;

import lombok.AllArgsConstructor;
import org.ecy.authjwt.security.reactive.AuthenticationManager;
import org.ecy.authjwt.security.reactive.JacksonWebTokenManager;
import org.ecy.authjwt.security.reactive.SecurityContextRepository;
import org.ecy.authjwt.security.reactive.TokenManager;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.context.ServerSecurityContextRepository;
import reactor.core.publisher.Mono;

@Configuration
@AllArgsConstructor
@EnableDiscoveryClient
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
@EnableReactiveMongoRepositories(basePackages = "com.ecy.authservice.repository")
public class AuthServiceConfiguration {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
                .csrf().disable()
                .authenticationManager(authenticationManager())
                .securityContextRepository(securityContextRepository())
                .formLogin().disable()
                .authorizeExchange()
                .pathMatchers("/login", "/signup", "/all").permitAll()
                .anyExchange().authenticated().and()
                .exceptionHandling()
                .authenticationEntryPoint((exchange, exception) -> Mono.error(exception))
                .accessDeniedHandler((exchange, denied) -> Mono.error(denied)).and()
                .httpBasic().disable()
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
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
