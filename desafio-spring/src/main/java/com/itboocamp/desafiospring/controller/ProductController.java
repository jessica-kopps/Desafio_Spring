package com.itboocamp.desafiospring.controller;

import com.itboocamp.desafiospring.controller.exception.DuplicateProductException;
import com.itboocamp.desafiospring.controller.exception.ValidatorException;
import com.itboocamp.desafiospring.controller.validator.IValidator;
import com.itboocamp.desafiospring.controller.validator.product.CategoryProductValidator;
import com.itboocamp.desafiospring.controller.validator.product.NameProductValidator;
import com.itboocamp.desafiospring.controller.validator.product.QuantityProductValidator;
import com.itboocamp.desafiospring.dto.mapper.ProductDTOMapper;
import com.itboocamp.desafiospring.dto.response.ProductResponseDTO;
import com.itboocamp.desafiospring.dto.resquest.ProductRequestDTO;
import com.itboocamp.desafiospring.entity.Product;
import com.itboocamp.desafiospring.entity.filter.ProductFilter;
import com.itboocamp.desafiospring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;


    @PostMapping(value = "/create")
    public ResponseEntity<ProductResponseDTO> create(@RequestBody ProductRequestDTO request) throws DuplicateProductException {
        Product product = productService.create(request);
        ProductResponseDTO productResponseDTO = new ProductDTOMapper().mapDTO(product);

        Product productName = productService.findByName(request.getName());
        Product productCategory = productService.findByCategory(request.getCategory());

        if (productName != null && productCategory != null) {
            throw new DuplicateProductException("Produto já cadastrados");
        }

        List<IValidator> validators = Arrays.asList(
                new CategoryProductValidator(product),
                new NameProductValidator(product),
                new QuantityProductValidator(product)
        );

        validators.forEach(v -> {
            try {
                v.validator();
            } catch (ValidatorException e) {
                e.printStackTrace();
            }
        });

        return ResponseEntity.ok().body(productResponseDTO);
    }


    @GetMapping("/listProducts")
    public ResponseEntity<List<ProductResponseDTO>> listProducts(ProductFilter filter){
        ProductDTOMapper mapper = new ProductDTOMapper();

        System.out.println(filter.toString());
        return ResponseEntity.ok().body(productService.listProducts(filter).stream().map((p)->mapper.mapDTO(p)).collect(Collectors.toList()));
    }

//    @GetMapping("/listProducts")
//    public ResponseEntity<List<ProductResponseDTO>> listProductsByCategory(@RequestParam(name = "category") String category){
//        ProductDTOMapper mapper = new ProductDTOMapper();
//        return ResponseEntity.ok()
//                .body(productService.getProductsByCategory(category).stream().map(p -> mapper.mapDTO(p))
//                .collect(Collectors.toList()));
//    }
}
