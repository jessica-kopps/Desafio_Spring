package com.itboocamp.desafiospring.dto.mapper;

import com.itboocamp.desafiospring.dto.response.ProductResponseDTO;
import com.itboocamp.desafiospring.dto.resquest.ProductPurchaseRequestDTO;
import com.itboocamp.desafiospring.entity.Product;
import com.itboocamp.desafiospring.repository.ProductRepository;

public class ProductDTOMapper {
    private final ProductRepository productRepository = new ProductRepository();

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

    public Product mapEntity(ProductPurchaseRequestDTO productPurchaseDTO) {
        Product product = productRepository.findById(productPurchaseDTO.getProductId());
        return product;
    }




}

