package com.ecy.inventoryservice.exception;

/**
 * Author: ecyamak
 * Date: 27.08.2023
 * Time: 16:24
 */

public class InventoryException extends RuntimeException {

    public InventoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public InventoryException(String message) {
        super(message);
    }

    public InventoryException(Throwable cause) {
        super(cause);
    }

}