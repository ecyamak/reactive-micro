package com.ecy.authservice.controller;

import com.ecy.authservice.entity.User;
import com.ecy.authservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class AuthRestController {

    private UserService userService;

    @PostMapping("/login")
    public Mono<Map<String, String>> login(@RequestBody User user) {
        return userService.authenticate(user)
                .filter(r -> !r.isEmpty())
                .map(r -> Map.of("token", r))
                .switchIfEmpty(Mono.empty());
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

    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/all")
    public Mono<Void> deleteAll() {
        return userService.deleteAll();
    }

    @GetMapping("/resource")
    public Map<String, Object> home() {
        Map<String, Object> model = new HashMap<>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello World");
        return model;
    }

}