package com.starbucksorder.another_back.controller;

import com.starbucksorder.another_back.exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> notFoundBoardException(UserNotFoundException e) {
        return ResponseEntity.status(404).body(e.getMessage());
    }
}
