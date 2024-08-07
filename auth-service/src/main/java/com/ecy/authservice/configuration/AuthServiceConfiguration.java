package com.ecy.authservice.configuration;

import com.ecy.authentication.reactive.jwt.AuthenticationManager;
import com.ecy.authentication.reactive.jwt.JacksonWebTokenManager;
import com.ecy.authentication.reactive.jwt.SecurityContextRepository;
import com.ecy.authentication.reactive.jwt.TokenManager;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.data.web.ReactivePageableHandlerMethodArgumentResolver;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.context.ServerSecurityContextRepository;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.result.method.annotation.ArgumentResolverConfigurer;
import reactor.core.publisher.Mono;

@Configuration
@EnableDiscoveryClient
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
@EnableReactiveMongoRepositories(basePackages = "com.ecy.authservice.repository")
public class AuthServiceConfiguration implements WebFluxConfigurer {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
                .csrf().disable()
                .authenticationManager(authenticationManager())
                .securityContextRepository(securityContextRepository())
                .formLogin().disable()
                .authorizeExchange()
                .pathMatchers("/auth/**").permitAll()
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

    @Bean
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

    @Override
    public void configureArgumentResolvers(ArgumentResolverConfigurer configurer) {
        configurer.addCustomResolver(new ReactivePageableHandlerMethodArgumentResolver());
    }

}