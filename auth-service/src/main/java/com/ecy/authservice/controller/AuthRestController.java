package com.ecy.authservice.controller;

import com.ecy.authservice.entity.User;
import com.ecy.authservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class AuthRestController {

    private UserService userService;

    @PostMapping("/login")
    public Mono<String> login(@RequestBody User user) {
        return userService.authenticate(user);
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<User> signup(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/all")
    public Flux<User> getAll() {
        return userService.getAll();
    }

    @DeleteMapping("/all")
    public Mono<Void> deleteAll() {
        return userService.deleteAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/info")
    public Mono<String> info() {
        return Mono.just("This is auth service.");
    }

}
