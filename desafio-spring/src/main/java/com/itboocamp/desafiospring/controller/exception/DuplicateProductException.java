package com.itboocamp.desafiospring.controller.exception;

public class DuplicateProductException extends Exception{

    private static final long serialVersionUID = 8514406528027778757L;

    public DuplicateProductException(String message) {
        super(message);
    }


}
