package com.itboocamp.desafiospring.controller.validator;
import com.itboocamp.desafiospring.controller.exception.ValidatorException;

public interface IValidator {
    void validator() throws ValidatorException;
}
