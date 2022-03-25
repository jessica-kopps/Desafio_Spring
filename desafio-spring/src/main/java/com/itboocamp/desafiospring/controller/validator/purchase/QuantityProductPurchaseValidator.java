package com.itboocamp.desafiospring.controller.validator.purchase;

import com.itboocamp.desafiospring.controller.exception.ValidatorException;
import com.itboocamp.desafiospring.controller.validator.IValidator;
import com.itboocamp.desafiospring.dto.request.ProductPurchaseRequestDTO;
import com.itboocamp.desafiospring.dto.request.ProductRequestDTO;
import com.itboocamp.desafiospring.entity.Product;

public class QuantityProductPurchaseValidator implements IValidator {
    private ProductPurchaseRequestDTO product;

    public QuantityProductPurchaseValidator(ProductPurchaseRequestDTO product) {
        this.product = product;
    }
    @Override
    public void validator() throws ValidatorException {
        if(product.getQuantity() <= 0) {
            throw new ValidatorException("Amount field must be greater than 0 (zero).");
        }
    }
}
