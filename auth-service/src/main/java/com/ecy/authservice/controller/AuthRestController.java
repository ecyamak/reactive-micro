package com.ecy.authservice.controller;

import com.ecy.authservice.dto.AccountDTO;
import com.ecy.authservice.entity.Account;
import com.ecy.authservice.entity.AccountVerification;
import com.ecy.authservice.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthRestController {

    private final AuthService authService;

    @PostMapping("/signin")
    public Mono<Map<String, String>> signin(@RequestBody AccountDTO accountDTO) {
        return authService.signin(accountDTO);
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Boolean> signup(@RequestBody AccountDTO accountDTO) {
        return authService.signup(accountDTO);
    }

    @GetMapping("/verify")
    public Mono<Boolean> verify(@RequestParam String verificationCode) {
        return authService.verify(verificationCode);
    }

    @GetMapping("/accounts")
    public Flux<Account> getAccounts() {
        return authService.getAccounts();
    }

    @DeleteMapping("/accounts")
    public Mono<Void> deleteAccounts() {
        return authService.deleteAccounts();
    }

    @GetMapping("/verifications")
    public Flux<AccountVerification> getVerfications() {
        return authService.getVerifications();
    }

    @DeleteMapping("/verifications")
    public Mono<Void> deleteVerifications() {
        return authService.deleteVerifications();
    }

}