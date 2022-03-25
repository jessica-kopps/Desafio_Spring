package com.itboocamp.desafiospring.service;

import com.itboocamp.desafiospring.dto.resquest.ProductRequestDTO;
import com.itboocamp.desafiospring.entity.Product;
import com.itboocamp.desafiospring.entity.filter.ProductFilter;
import com.itboocamp.desafiospring.entity.mapper.EntityMapper;
import com.itboocamp.desafiospring.repository.ProductRepository;
import com.itboocamp.desafiospring.controller.exception.DuplicateProductException;
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

    public Product create(ProductRequestDTO request) {
        return productRepository.insert(new EntityMapper().mapDTO(request));
    }

    public List<Product> getProductsByCategory(String category){
        List<Product> productList = productRepository.findAll();
        return productList.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    public Product findByCategory(String category) {
        return productRepository.findByCategory(category);
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
                return product.getName().toUpperCase().contains(filter.getName().toUpperCase());
            }).collect(Collectors.toList());
            if (listFiltered.size() == 0) return listFiltered;
        }
        if (filter.getCategory() != null) {
            listFiltered = listFiltered.stream().filter(product -> {
                return product.getCategory().toUpperCase().contains(filter.getCategory().toUpperCase());
            }).collect(Collectors.toList());
            if (listFiltered.size() == 0) return listFiltered;
        }
        if (filter.getBrand() != null) {
            listFiltered = listFiltered.stream().filter(product -> {
                return product.getBrand().toUpperCase().contains(filter.getBrand().toUpperCase());
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
