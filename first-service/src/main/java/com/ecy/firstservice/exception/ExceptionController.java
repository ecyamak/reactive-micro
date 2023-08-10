package com.ecy.firstservice.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;

import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Author: ecyamak
 * Date: 9.08.2023
 * Time: 16:15
 */

@Slf4j
@ControllerAdvice
public class ExceptionController {

    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler({DataAccessException.class, PropertyReferenceException.class, IllegalArgumentException.class, IllegalStateException.class})
    public void handleDataIntegrityViolationException(Exception exception) {
        log.error(exception.getMessage());
        exception.printStackTrace();
    }

}