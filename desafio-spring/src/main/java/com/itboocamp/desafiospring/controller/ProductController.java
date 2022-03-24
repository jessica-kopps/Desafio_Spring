package com.itboocamp.desafiospring.controller;

import com.itboocamp.desafiospring.repository.ProductRepository;
import com.itboocamp.desafiospring.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    public ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


}
