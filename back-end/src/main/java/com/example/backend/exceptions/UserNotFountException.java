package com.example.backend.exceptions;

public class UserNotFountException extends RuntimeException {
    public UserNotFountException(String msg) {
        super(msg);
    }

}
