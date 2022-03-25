package com.itboocamp.desafiospring.controller.exception.purchase;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
