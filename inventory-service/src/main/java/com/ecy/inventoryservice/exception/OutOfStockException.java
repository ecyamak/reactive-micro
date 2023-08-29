package com.ecy.inventoryservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Author: ecyamak
 * Date: 27.08.2023
 * Time: 13:50
 */

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class OutOfStockException extends InventoryException {

    public OutOfStockException(String message) {
        super(message);
    }

}