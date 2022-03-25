package com.itboocamp.desafiospring.dto.mapper;

import com.itboocamp.desafiospring.dto.response.ProductResponseDTO;
import com.itboocamp.desafiospring.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductDTOMapper {

    public ProductResponseDTO mapDTO(Product entity) {
        return new ProductResponseDTO().builder()
                .productId(entity.getProductId())
                .name(entity.getName())
                .category(entity.getCategory())
                .brand(entity.getBrand())
                .price(entity.getPrice())
                .quantity(entity.getQuantity())
                .freeShipping(entity.getFreeShipping())
                .prestige(entity.getPrestige()).build();
    }

    public List<ProductResponseDTO> mapDTO(List<Product> products){
        return products.stream().map((p)->this.mapDTO(p)).collect(Collectors.toList());
    }


}

