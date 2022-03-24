package com.itboocamp.desafiospring.controller;

import com.itboocamp.desafiospring.dto.mapper.ProductDTOMapper;
import com.itboocamp.desafiospring.dto.response.ProductResponseDTO;
import com.itboocamp.desafiospring.dto.resquest.ProductRequestDTO;
import com.itboocamp.desafiospring.entity.Product;
import com.itboocamp.desafiospring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/create")
    public ResponseEntity<ProductResponseDTO> create(@RequestBody ProductRequestDTO request) {
        Product product = productService.create(request);
        ProductResponseDTO productResponseDTO = new ProductDTOMapper().mapDTO(product);
        return ResponseEntity.ok().body(productResponseDTO);
    }

    @GetMapping("/listProducts")
    public ResponseEntity<List<ProductResponseDTO>> listProducts(){
        ProductDTOMapper mapper = new ProductDTOMapper();


        return ResponseEntity.ok().body(productService.listProducts().stream().map((p)->mapper.mapDTO(p)).collect(Collectors.toList()));



    }


}
