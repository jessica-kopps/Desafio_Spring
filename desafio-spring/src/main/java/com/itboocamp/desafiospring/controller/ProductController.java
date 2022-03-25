package com.itboocamp.desafiospring.controller;

import com.itboocamp.desafiospring.dto.mapper.ProductDTOMapper;
import com.itboocamp.desafiospring.dto.response.ProductResponseDTO;
import com.itboocamp.desafiospring.dto.resquest.ProductRequestDTO;
import com.itboocamp.desafiospring.entity.Product;
import com.itboocamp.desafiospring.entity.filter.ProductFilter;
import com.itboocamp.desafiospring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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
    public ResponseEntity<List<ProductResponseDTO>> listProducts(@RequestParam(required = false) Long id,
                                                                 @RequestParam(required = false) String name,
                                                                 @RequestParam(required = false) String category,
                                                                 @RequestParam(required = false) String brand,
                                                                 @RequestParam(required = false) BigDecimal price,
                                                                 @RequestParam(required = false) Integer quantity,
                                                                 @RequestParam(required = false) Boolean freeShipping,
                                                                 @RequestParam(required = false) Double prestige,
                                                                 @RequestParam(required = false) String priceSort,
                                                                 @RequestParam(required = false) String nameSort) {
        ProductFilter productFilter = ProductFilter.builder().productId(id).name(name).category(category).brand(brand).price(price)
                .quantity(quantity).freeShipping(freeShipping).prestige(prestige).build();
        ProductDTOMapper mapper = new ProductDTOMapper();
        return ResponseEntity.ok().body(mapper.mapDTO(productService.listProducts(productFilter, priceSort, nameSort)));
    }
}
