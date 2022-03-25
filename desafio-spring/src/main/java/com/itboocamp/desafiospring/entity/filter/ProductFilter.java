package com.itboocamp.desafiospring.entity.filter;

import com.itboocamp.desafiospring.entity.Product;
import lombok.*;

import javax.sound.sampled.Port;
import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductFilter {

    private Long productId;
    private String name;
    private String category;
    private String brand;
    private BigDecimal price;
    private Integer quantity;
    private Boolean freeShipping;
    private Double prestige;
    private List<Product> productsList;

    public ProductFilter filterName() {
        if (this.name != null) {
            this.productsList = this.productsList.stream()
                    .filter(product -> {
                        return product.getName().toUpperCase().contains(this.name.toUpperCase());
                    }).collect(Collectors.toList());
        }
        return this;
    }

    public ProductFilter filterProductId() {
        if (this.productId != null) {
            this.productsList = this.productsList.stream()
                    .filter(product -> {
                        return this.productId.compareTo(product.getProductId()) == 0;
                    }).collect(Collectors.toList());
        }
        return this;
    }

    public ProductFilter filterCategory() {
        if (this.category != null) {
            this.productsList = this.productsList.stream()
                    .filter(product -> {
                        return product.getCategory().toUpperCase().contains(this.category.toUpperCase());
                    }).collect(Collectors.toList());
        }
        return this;
    }

    public ProductFilter filterBrand() {
        if (this.brand != null) {
            this.productsList = this.productsList.stream()
                    .filter(product -> {
                        return product.getBrand().toUpperCase().contains(this.brand.toUpperCase());
                    }).collect(Collectors.toList());
        }
        return this;
    }

    public ProductFilter filterPrice() {
        if (this.price != null) {
            this.productsList = this.productsList.stream()
                    .filter(product -> {
                        return product.getPrice().compareTo(this.price) == 0;
                    }).collect(Collectors.toList());
        }
        return this;
    }

    public ProductFilter filterQuantity() {
        if (this.quantity != null) {
            this.productsList = this.productsList.stream()
                    .filter(product -> {
                        return product.getQuantity() == this.quantity;
                    }).collect(Collectors.toList());
        }
        return this;
    }

    public ProductFilter filterFreeShipping() {
        if (this.freeShipping != null) {
            this.productsList = this.productsList.stream()
                    .filter(product -> {
                        return this.freeShipping.compareTo(product.getFreeShipping()) == 0;
                    }).collect(Collectors.toList());
        }
        return this;
    }

    public ProductFilter filterPrestige() {
        if (this.prestige != null) {
            this.productsList = this.productsList.stream()
                    .filter(product -> {
                        return this.prestige.compareTo(product.getPrestige()) == 0;
                    }).collect(Collectors.toList());
        }
        return this;
    }

}
