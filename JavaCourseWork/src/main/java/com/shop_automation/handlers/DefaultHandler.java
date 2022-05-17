package com.shop_automation.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class DefaultHandler {

    @ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity<Response> handleException(Exception e) {
        Response response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}


