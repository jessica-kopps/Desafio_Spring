package com.itboocamp.desafiospring.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Purchase {
    private List<Product> products = new ArrayList<>();
    private BigDecimal totalPrice;
}
