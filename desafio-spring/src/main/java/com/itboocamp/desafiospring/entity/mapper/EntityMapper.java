package com.itboocamp.desafiospring.entity.mapper;

import com.itboocamp.desafiospring.dto.request.ProductRequestDTO;
import com.itboocamp.desafiospring.entity.Product;

public class EntityMapper {

    public Product mapDTO(ProductRequestDTO productRequestDTO) {
        return new Product(
                productRequestDTO.getName(),
                productRequestDTO.getCategory(),
                productRequestDTO.getBrand(),
                productRequestDTO.getPrice(),
                productRequestDTO.getQuantity(),
                productRequestDTO.getFreeShipping(),
                productRequestDTO.getPrestige());
    }
}
