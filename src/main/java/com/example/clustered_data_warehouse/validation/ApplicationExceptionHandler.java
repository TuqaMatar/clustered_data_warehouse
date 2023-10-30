package com.example.clustered_data_warehouse.validation;

import com.example.clustered_data_warehouse.controller.DealController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(ApplicationExceptionHandler.class);
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            logger.trace("error for field" + error.getField()+ " " + error.getDefaultMessage());
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return errorMap;
    }

}