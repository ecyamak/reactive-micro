package com.ecy.authservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Author: ecyamak
 * Date: 8.08.2023
 * Time: 18:02
 */

@ResponseStatus(HttpStatus.FORBIDDEN)
public class AuthenticationException extends RuntimeException {

    public AuthenticationException(String message) {
        super(message);
    }

    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }

}