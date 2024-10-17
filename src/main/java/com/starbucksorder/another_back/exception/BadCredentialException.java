package com.starbucksorder.another_back.exception;

import org.springframework.security.authentication.BadCredentialsException;

public class BadCredentialException extends BadCredentialsException {
    public BadCredentialException(String msg) {
        super(msg);
    }
}
