package com.ecy.orderservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Author: ecyamak
 * Date: 10.08.2023
 * Time: 23:26
 */


@ControllerAdvice
public class OrderExceptionController {

    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(RuntimeException.class)
    public void handleExceptions(ServerHttpRequest request, Exception exception) {
        exception.printStackTrace();
    }
}