package com.itboocamp.desafiospring.controller.validator.product;

import com.itboocamp.desafiospring.controller.exception.ValidatorException;
import com.itboocamp.desafiospring.controller.validator.IValidator;
import com.itboocamp.desafiospring.dto.request.ProductRequestDTO;

public class QuantityProductValidator implements IValidator {
    private ProductRequestDTO product;

    public QuantityProductValidator(ProductRequestDTO product) {
        this.product = product;
    }

    @Override
    public void validator() throws ValidatorException {
        if(product.getQuantity() <= 0) {
            throw new ValidatorException("Amount field must be greater than 0 (zero).");
        }

    }
}
