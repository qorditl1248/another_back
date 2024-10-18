package com.starbucksorder.another_back.exception;

public class AccessTokenValidException extends RuntimeException {
    public AccessTokenValidException(String message) {
        super(message);
    }
}
