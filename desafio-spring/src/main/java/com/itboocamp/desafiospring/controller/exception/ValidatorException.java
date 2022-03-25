package com.itboocamp.desafiospring.controller.exception;

public class ValidatorException extends RuntimeException{
    private static final long serialVersionUID = 8514406528027778757L;
    public ValidatorException(String message) {
        super(message);
    }
}
