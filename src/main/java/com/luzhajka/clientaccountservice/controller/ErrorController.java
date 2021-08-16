package com.luzhajka.clientaccountservice.controller;

import com.luzhajka.clientaccountservice.exceptions.ClientAccountNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ErrorController {
    @ExceptionHandler(ClientAccountNotFoundException.class)
    public ResponseEntity handleException(ClientAccountNotFoundException e) {
        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @InitBinder
    private void initBinder(WebDataBinder binder, WebRequest webRequest) {
    }
}
