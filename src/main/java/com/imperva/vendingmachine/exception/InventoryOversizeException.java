package com.imperva.vendingmachine.exception;

public class InventoryOversizeException extends RuntimeException {

    public InventoryOversizeException() {
    }

    public InventoryOversizeException(String message) {
        super(message);
    }

}
