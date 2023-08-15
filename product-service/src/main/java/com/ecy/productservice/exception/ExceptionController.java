package com.ecy.productservice.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Author: ecyamak
 * Date: 11.08.2023
 * Time: 01:32
 */

@ControllerAdvice
public class ExceptionController {

    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(DataAccessException.class)
    public void handleExceptions(ServerHttpRequest request, Exception exception) {
        exception.printStackTrace();
    }

}