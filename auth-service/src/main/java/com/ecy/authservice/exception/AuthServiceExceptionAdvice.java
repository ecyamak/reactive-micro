package com.ecy.authservice.exception;

import com.ecy.authservice.dto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Author: ecyamak
 * Date: 6.08.2023
 * Time: 21:02
 */

@Slf4j
@ControllerAdvice
public class AuthServiceExceptionAdvice {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public @ResponseBody ErrorResponse handleRuntimeException(ServerHttpRequest request, Exception exception) {
        log.error(exception.getMessage(), exception);
        return new ErrorResponse(request, HttpStatus.INTERNAL_SERVER_ERROR, exception);
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DuplicateKeyException.class)
    public @ResponseBody ErrorResponse handleDataAccessException(ServerHttpRequest request, Exception exception) {
        log.error(exception.getMessage(), exception);
        return new ErrorResponse(request, HttpStatus.CONFLICT, exception);
    }
}