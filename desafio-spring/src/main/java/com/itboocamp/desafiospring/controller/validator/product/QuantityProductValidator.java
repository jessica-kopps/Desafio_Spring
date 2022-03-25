package com.itboocamp.desafiospring.controller.validator.product;

import com.itboocamp.desafiospring.controller.exception.ValidatorException;
import com.itboocamp.desafiospring.controller.validator.IValidator;
import com.itboocamp.desafiospring.dto.resquest.ProductRequestDTO;

public class QuantityProductValidator implements IValidator {
    private ProductRequestDTO product;

    public QuantityProductValidator(ProductRequestDTO product) {
        this.product = product;
    }

    @Override
    public void validator() throws ValidatorException {
        if(product.getQuantity() <= 0) {
            throw new ValidatorException("Campo quantidade deve ser maior que 0 (zero).");
        }

    }
}
