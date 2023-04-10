package com.ecy.authservice.service.impl;

import com.ecy.authservice.entity.User;
import com.ecy.authservice.exception.AuthorizationException;
import com.ecy.authservice.repository.UserRepository;
import com.ecy.authservice.service.UserService;
import lombok.AllArgsConstructor;
import org.ecy.authjwt.security.reactive.TokenManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenManager tokenManager;

    @Override
    @Transactional
    public Mono<User> save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Mono<User> get(User user) {
        return repository.findByUsername(user.getUsername());
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Flux<User> getAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Mono<String> authenticate(User user) {
        return get(user)
                .filter(u -> passwordEncoder.matches(user.getPassword(), u.getPassword()))
                .map(u -> tokenManager.generateToken(u).block())
                .switchIfEmpty(Mono.error(new AuthorizationException("401 Unauthorized")));
    }

    @Override
    @Transactional
    public Mono<Void> deleteAll() {
        return repository.deleteAll();
    }

}