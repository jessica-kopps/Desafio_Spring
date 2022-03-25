package com.itboocamp.desafiospring.controller.exception.product;

public class DuplicateProductException extends RuntimeException{

    private static final long serialVersionUID = 8514406528027778757L;

    public DuplicateProductException(String message) {
        super(message);
    }
}
