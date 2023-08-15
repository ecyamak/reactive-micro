package com.ecy.productservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Author: ecyamak
 * Date: 11.08.2023
 * Time: 03:30
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequestParamMismatch extends RuntimeException {

}