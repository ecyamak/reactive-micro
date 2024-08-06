package com.ecy.authservice.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import lombok.Getter;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * Author: ecyamak
 * Date: 16.07.2024
 * Time: 23:17
 */

@Getter
public abstract class Response {

    private final Instant timestamp;
    private final String requestId;
    private final String path;
    private final int status;
    private final String message;

    protected Response(ServerHttpRequest request, HttpStatus httpStatus) {
        this.timestamp = Instant.now().truncatedTo(ChronoUnit.SECONDS);
        this.requestId = request.getId();
        this.path = request.getURI().getPath();
        this.status = httpStatus.value();
        this.message = httpStatus.getReasonPhrase();
    }

}
