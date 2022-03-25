package com.itboocamp.desafiospring.controller.exception.purchase;

public class InsufficientQuantityException extends RuntimeException {
    public InsufficientQuantityException(String message) {
        super(message);
    }
}
