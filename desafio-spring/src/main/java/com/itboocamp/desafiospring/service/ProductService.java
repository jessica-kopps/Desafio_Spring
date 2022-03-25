package com.itboocamp.desafiospring.service;

import com.itboocamp.desafiospring.entity.Product;
import com.itboocamp.desafiospring.entity.filter.ProductFilter;
import com.itboocamp.desafiospring.entity.mapper.EntityMapper;
import com.itboocamp.desafiospring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Collectors;


@Service
public class ProductService {
    @Autowired
    private ProductRepository  productRepository;

    public List<Product> getProductsByCategory(String category){
        List<Product> productList = productRepository.findAll();
        return productList.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public List<Product> listProducts(ProductFilter filters) {
        return filter(filters, productRepository.findAll());
    }

    private List<Product> filter (ProductFilter filter, List<Product> list) {
        List<Product> listFiltered = list;

        if (filter.getProductId() != null) {
            listFiltered = list.stream().filter(product -> {
                return filter.getProductId() == product.getProductId();
            }).collect(Collectors.toList());
              if (listFiltered.size() == 0) return listFiltered;
        }
        if (filter.getName() != null) {
            listFiltered = listFiltered.stream().filter(product -> {
                return filter.getName().toUpperCase(Locale.ROOT).equals(product.getName().toUpperCase());
            }).collect(Collectors.toList());
            if (listFiltered.size() == 0) return listFiltered;
        }
        if (filter.getCategory() != null) {
            listFiltered = listFiltered.stream().filter(product -> {
                return filter.getCategory().toUpperCase(Locale.ROOT).equals(product.getCategory().toUpperCase());
            }).collect(Collectors.toList());
            if (listFiltered.size() == 0) return listFiltered;
        }
        if (filter.getBrand() != null) {
            listFiltered = listFiltered.stream().filter(product -> {
                String str1 = filter.getBrand().toUpperCase();
                String str2 = product.getBrand().toUpperCase();
                return str2.contains(str1);
            }).collect(Collectors.toList());
            if (listFiltered.size() == 0) return listFiltered;
        }
        if (filter.getPrice() != null) {
            listFiltered = listFiltered.stream().filter(product -> {
                return filter.getPrice() == product.getPrice();
            }).collect(Collectors.toList());
            if (listFiltered.size() == 0) return listFiltered;
        }
        if (filter.getQuantity() != null) {
            listFiltered = listFiltered.stream().filter(product -> {
                return filter.getQuantity() == product.getQuantity();
            }).collect(Collectors.toList());
            if (listFiltered.size() == 0) return listFiltered;
        }
        if (filter.getFreeShipping() != null) {
            listFiltered = listFiltered.stream().filter(product -> {
                return filter.getFreeShipping() == product.getFreeShipping();
            }).collect(Collectors.toList());
            if (listFiltered.size() == 0) return listFiltered;
        }
        if (filter.getPrestige() != null) {
            listFiltered = listFiltered.stream().filter(product -> {
                return filter.getPrestige() == product.getPrestige();
            }).collect(Collectors.toList());
            if (listFiltered.size() == 0) return listFiltered;
        }

        return listFiltered;
    }
}
