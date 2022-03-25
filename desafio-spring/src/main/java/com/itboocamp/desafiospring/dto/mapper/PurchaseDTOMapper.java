package com.itboocamp.desafiospring.dto.mapper;

import com.itboocamp.desafiospring.controller.exception.purchase.InsufficientQuantityException;
import com.itboocamp.desafiospring.dto.response.ProductResponseDTO;
import com.itboocamp.desafiospring.dto.response.PurchaseResponseDTO;
import com.itboocamp.desafiospring.dto.resquest.ProductPurchaseRequestDTO;
import com.itboocamp.desafiospring.dto.resquest.PurchaseRequestDTO;
import com.itboocamp.desafiospring.entity.Product;
import com.itboocamp.desafiospring.entity.Purchase;
import com.itboocamp.desafiospring.repository.ProductProductRepository;
import com.itboocamp.desafiospring.controller.exception.purchase.NotFoundException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PurchaseDTOMapper {
    private ProductProductRepository productRepository = new ProductProductRepository();

    public PurchaseResponseDTO mapDTO(Purchase purchase) {
        ProductDTOMapper productDTOMapper = new ProductDTOMapper();
        return new PurchaseResponseDTO(productDTOMapper.mapDTO(purchase.getProducts()), purchase.getTotalPrice());
    }
}