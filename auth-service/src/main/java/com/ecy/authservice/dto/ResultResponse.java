package com.ecy.authservice.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;

import lombok.Getter;

/**
 * Author: ecyamak
 * Date: 17.07.2024
 * Time: 00:44
 */

@Getter
public class ResultResponse extends Response {

    private final Object result;

    public ResultResponse(ServerHttpRequest request, HttpStatus httpStatus, Object result) {
        super(request, httpStatus);
        this.result = result;
    }
}
