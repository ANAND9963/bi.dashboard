package com.joy.bi.dashboard.exception;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(String message){
        super(message);
    }
}
