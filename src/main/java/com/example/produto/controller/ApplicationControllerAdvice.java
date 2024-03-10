package com.example.produto.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.produto.exception.ProdutoException;

@RestControllerAdvice
public class ApplicationControllerAdvice {
    @ExceptionHandler(ProdutoException.class)
    public ResponseEntity<Object> handleException(ProdutoException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
