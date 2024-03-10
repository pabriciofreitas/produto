package com.example.produto.exception;

public class ProdutoException extends Exception {
    public ProdutoException(String message) {
        super(message);
    }

    public ProdutoException(String message, Exception exception) {
        super(message, exception);
    }

    public ProdutoException(Exception exception) {
        super(exception);
    }
}
