package com.ecy.authservice.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Author: ecyamak
 * Date: 16.07.2024
 * Time: 23:25
 */

@Getter
public class ErrorResponse extends Response {

    private final ErrorDetail error;

    public ErrorResponse(ServerHttpRequest request, HttpStatus httpStatus, Exception exception) {
        super(request, httpStatus);
        error = new ErrorDetail(exception.getClass().getName(), exception.getMessage());
    }

    @Getter
    @AllArgsConstructor
    class ErrorDetail {
        private final String name;
        private final String detail;
    }

}
