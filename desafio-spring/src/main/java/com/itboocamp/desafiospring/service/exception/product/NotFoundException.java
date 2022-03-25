package com.itboocamp.desafiospring.service.exception.product;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
