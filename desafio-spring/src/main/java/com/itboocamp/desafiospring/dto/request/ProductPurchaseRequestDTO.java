package com.itboocamp.desafiospring.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductPurchaseRequestDTO {
    private Long productId;
    private String name;
    private String brand;
    private Integer quantity;
}