package com.imperva.vendingmachine.exception;

public class NicknameAlreadyExistsException extends RuntimeException {

    public NicknameAlreadyExistsException() {
    }

    public NicknameAlreadyExistsException(String message) {
        super(message);
    }

}
