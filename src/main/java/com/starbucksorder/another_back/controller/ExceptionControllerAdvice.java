package com.starbucksorder.another_back.controller;

import com.starbucksorder.another_back.exception.BadCredentialException;
import com.starbucksorder.another_back.exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> notFoundBoardException(UserNotFoundException e) {
        return ResponseEntity.status(404).body(e.getMessage());
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<?> notFoundUsernameException(UsernameNotFoundException e) {
        return ResponseEntity.status(404).body(e.getMessage());
    }

    @ExceptionHandler(BadCredentialException.class)
    public ResponseEntity<?> badCredentialException(BadCredentialException e) {
        return ResponseEntity.status(401).body(e.getMessage());
    }
}
