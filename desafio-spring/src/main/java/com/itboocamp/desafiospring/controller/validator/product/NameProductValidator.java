package com.itboocamp.desafiospring.controller.validator.product;

import com.itboocamp.desafiospring.controller.exception.ValidatorException;
import com.itboocamp.desafiospring.controller.validator.IValidator;
import com.itboocamp.desafiospring.entity.Product;

public class NameProductValidator implements IValidator {
    private Product product;

    public NameProductValidator(Product product) {
        this.product = product;
    }

    @Override
    public void validator() throws ValidatorException {
        if(product.getName().isEmpty() || product.getName().length() > 3) {
            throw new ValidatorException("Campo nome precisa ser preenchido e conter mais de 3 caracteres.");
        }

    }
}
