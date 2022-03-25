package com.itboocamp.desafiospring.dto.resquest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

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
