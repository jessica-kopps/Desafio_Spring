package com.itboocamp.desafiospring.entity;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Product {

    private Long productId;
    private String name;
    private String category;
    private BigDecimal price;
    private Integer quantity;
    private Boolean freeShipping;
    private Double prestige;

}
