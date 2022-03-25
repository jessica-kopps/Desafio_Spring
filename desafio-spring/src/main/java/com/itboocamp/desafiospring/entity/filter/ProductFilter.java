package com.itboocamp.desafiospring.entity.filter;

import com.itboocamp.desafiospring.entity.Product;
import lombok.*;

import javax.sound.sampled.Port;
import java.math.BigDecimal;
import java.util.List;
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

    public List<Product> filterName (List<Product> list) {
        if(this.name != null) {
            return list.stream()
                    .filter(product -> {
                        return this.name.toUpperCase().contains(product.getName().toUpperCase());
                    }).collect(Collectors.toList());
        }
        return list;
    }

    public List<Product> filterProductId (List<Product> list) {
        if(this.productId != null) {
            return list.stream()
                    .filter(product -> {
                        return this.productId.compareTo(product.getProductId()) == 0;
                    }).collect(Collectors.toList());
        }
        return list;
    }

    public List<Product> filterCategory (List<Product> list) {
        if(this.category != null) {
            return list.stream()
                    .filter(product -> {
                        return product.getCategory().toUpperCase().contains(this.category);
                    }).collect(Collectors.toList());
        }
        return list;
    }

    public List<Product> filterBrand (List<Product> list) {
        if(this.brand != null) {
            return list.stream()
                    .filter(product -> {
                        return product.getBrand().toUpperCase().contains(this.brand);
                    }).collect(Collectors.toList());
        }
        return list;
    }

    public List<Product> filterPrice (List<Product> list) {
        if(this.price != null) {
            return list.stream()
                    .filter(product -> {
                        return product.getPrice().compareTo(this.price) == 0;
                    }).collect(Collectors.toList());
        }
        return list;
    }

    public List<Product> filterQuantity (List<Product> list) {
        if(this.quantity != null) {
            return list.stream()
                    .filter(product -> {
                        return product.getQuantity() == this.quantity;
                    }).collect(Collectors.toList());
        }
        return list;
    }

    public List<Product> filterFreeShipping (List<Product> list) {
        if(this.freeShipping != null) {
            return list.stream()
                    .filter(product -> {
                        return this.freeShipping.compareTo(product.getFreeShipping()) == 0;
                    }).collect(Collectors.toList());
        }
        return list;
    }

    public List<Product> filterPrestige (List<Product> list) {
        if(this.prestige != null) {
            return list.stream()
                    .filter(product -> {
                        return this.prestige.compareTo(product.getPrestige()) == 0;
                    }).collect(Collectors.toList());
        }
        return list;
    }

}
