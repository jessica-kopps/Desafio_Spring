package com.itboocamp.desafiospring.service.validator;

import com.itboocamp.desafiospring.service.exception.ValidatorException;

public interface IValidator {
    void validator() throws ValidatorException;
}
