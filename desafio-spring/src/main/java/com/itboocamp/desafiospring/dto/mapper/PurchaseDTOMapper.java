package com.itboocamp.desafiospring.dto.mapper;

import com.itboocamp.desafiospring.dto.response.PurchaseResponseDTO;
import com.itboocamp.desafiospring.entity.Purchase;

public class PurchaseDTOMapper {
    public PurchaseResponseDTO mapDTO(Purchase purchase) {
        ProductDTOMapper productDTOMapper = new ProductDTOMapper();
        return new PurchaseResponseDTO(productDTOMapper.mapDTO(purchase.getProducts()), purchase.getTotalPrice());
    }
}