package com.starbucksorder.another_back.exception;

import lombok.Data;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class ValidException extends RuntimeException {
    private Map<String, Object> fieldErrors;

    public ValidException(String message, List<FieldError> fieldErrors) {
        super(message);
        this.fieldErrors = new HashMap<>();
        this.fieldErrors.put("defaultMessage", fieldErrors.stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)));
    }
}
