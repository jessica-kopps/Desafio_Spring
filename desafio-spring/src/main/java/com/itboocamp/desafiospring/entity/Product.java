package com.itboocamp.desafiospring.entity;

import lombok.*;

import java.math.BigDecimal;
import java.util.Random;

@Getter
public class Product {
    private Long productId;
    private String name;
    private String category;
    private String brand;
    private BigDecimal price;
    private Integer quantity;
    private Boolean freeShipping;
    private Double prestige;

    public Product(String name, String category, String brand, BigDecimal price, Integer quantity, Boolean freeShipping, Double prestige) {
        this.productId = nextInt();
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        this.freeShipping = freeShipping;
        this.prestige = prestige;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setFreeShipping(Boolean freeShipping) {
        this.freeShipping = freeShipping;
    }

    public void setPrestige(Double prestige) {
        this.prestige = prestige;
    }

    private Long nextInt() {
        long lowerLimit = 123456712L;
        long upperLimit = 234567892L;
        Random r = new Random();
        return lowerLimit+((long)(r.nextDouble()*(upperLimit-lowerLimit)));
    }

}
