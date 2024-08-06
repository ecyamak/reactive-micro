package com.ecy.authservice.exception;

/**
 * Author: ecyamak
 * Date: 17.07.2024
 * Time: 18:00
 */

public abstract class ServiceException extends Exception {

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}
