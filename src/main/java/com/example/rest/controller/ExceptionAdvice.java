package com.example.rest.controller;

import com.example.rest.exceptions.InvalidCredentials;
import com.example.rest.exceptions.UnauthorizedUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(InvalidCredentials.class)
    ResponseEntity<String> handleICE(InvalidCredentials exc) {
        return new ResponseEntity<>(exc.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    ResponseEntity<String> handleUUE(UnauthorizedUser exc) {
        return new ResponseEntity<>(exc.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
