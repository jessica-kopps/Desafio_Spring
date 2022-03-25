package com.itboocamp.desafiospring.service;

import com.itboocamp.desafiospring.entity.Product;
import com.itboocamp.desafiospring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductService {

    private ProductRepository  productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductService() {

    }

    public List<Product> getProductsByCategory(String category){
        List<Product> productList = productRepository.findAll();
        return productList.stream()
                .filter(product -> product.getCategory().toLowerCase().equals(category.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Product> listProducts() {
        return productRepository.findAll();
    }
}
