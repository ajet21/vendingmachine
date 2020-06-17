package com.imperva.vendingmachine.exception;

public class NotEnoughBalanceException extends RuntimeException {

    public NotEnoughBalanceException() {
    }

    public NotEnoughBalanceException(String message) {
        super(message);
    }

}
