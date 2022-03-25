package com.itboocamp.desafiospring.controller.validator.product;

import com.itboocamp.desafiospring.controller.exception.ValidatorException;
import com.itboocamp.desafiospring.controller.validator.IValidator;
import com.itboocamp.desafiospring.dto.request.ProductRequestDTO;

public class NameProductValidator implements IValidator {
    private ProductRequestDTO product;

    public NameProductValidator(ProductRequestDTO product) {
        this.product = product;
    }

    @Override
    public void validator() throws ValidatorException {
        if(product.getName().isEmpty() || product.getName().length() <= 3) {
            throw new ValidatorException("Name field must be filled in and contain more than 3 characters.");
        }

    }
}
