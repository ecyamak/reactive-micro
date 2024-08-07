package com.ecy.authservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Author: ecyamak
 * Date: 10.04.2023
 * Time: 03:08
 */

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class AuthorizationException extends ServiceException {

    public AuthorizationException(String message) {
        super(message);
    }

    public AuthorizationException(String message, Throwable cause) {
        super(message, cause);
    }

}