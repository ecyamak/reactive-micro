package com.ecy.data.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Author: ecyamak
 * Date: 27.08.2023
 * Time: 22:31
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequestParamMismatch extends RuntimeException {

}