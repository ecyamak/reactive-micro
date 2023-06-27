package com.ecy.authservice.controller;

import com.ecy.authservice.entity.Account;
import com.ecy.authservice.entity.AccountVerification;
import com.ecy.authservice.entity.User;
import com.ecy.authservice.manager.AccountManager;
import com.ecy.authservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@AllArgsConstructor
public class AuthRestController {

    private final UserService userService;
    private final AccountManager accountManager;

    @PostMapping("/signin")
    public Mono<Map<String, String>> signin(@RequestBody User user) {
        return userService.authenticate(user)
                .filter(r -> !r.isEmpty())
                .map(r -> Map.of("token", r))
                .switchIfEmpty(Mono.empty());
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Void> signup(@RequestBody Account account) {
        return accountManager.createAccount(account);
    }

    @GetMapping("/verify")
    public Mono<Boolean> verify(@RequestParam String verificationCode) {
        return accountManager.verifyAccount(verificationCode);
    }

    @GetMapping("/all")
    public Flux<Account> getAll() {
        return accountManager.getAllAccounts();
    }

    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/all")
    public Mono<Boolean> deleteAll() {
        return accountManager.deleteAllAccounts();
    }

    @GetMapping("/aall")
    public Flux<AccountVerification> getAall() {
        return accountManager.getAllVerifications();
    }

    @DeleteMapping("/aall")
    public Mono<Boolean> getDeleteAall() {
        return accountManager.deleteAllVerifications();
    }

}