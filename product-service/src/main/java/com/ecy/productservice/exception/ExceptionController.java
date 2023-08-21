package com.ecy.productservice.exception;

import io.github.resilience4j.bulkhead.BulkheadFullException;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.concurrent.TimeoutException;

/**
 * Author: ecyamak
 * Date: 11.08.2023
 * Time: 01:32
 */

@Slf4j
@ControllerAdvice
public class ExceptionController {

    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(DataAccessException.class)
    public void handleExceptions(ServerHttpRequest request, Exception exception) {
        exception.printStackTrace();
    }

    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(CallNotPermittedException.class)
    public void handleCallNotPermit(ServerHttpRequest request, Exception exception) {
        log.error(exception.getMessage(), exception);
    }

    @ResponseStatus(HttpStatus.REQUEST_TIMEOUT)
    @ExceptionHandler(TimeoutException.class)
    public void handleTimeoutException(ServerHttpRequest request, Exception exception) {
        log.error(exception.getMessage(), exception);
    }

    @ResponseStatus(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED)
    @ExceptionHandler(BulkheadFullException.class)
    public void handleBulkheadFullException(ServerHttpRequest request, Exception exception) {
        log.error(exception.getMessage(), exception);
    }

    @ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
    @ExceptionHandler(RequestNotPermitted.class)
    public void handleRequestNotPermitted(ServerHttpRequest request, Exception exception) {
        log.error(exception.getMessage(), exception);
    }

}