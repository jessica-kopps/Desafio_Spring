package com.itboocamp.desafiospring.controller;

import com.itboocamp.desafiospring.entity.mapper.EntityMapper;
import org.springframework.web.util.UriComponentsBuilder;
import com.itboocamp.desafiospring.controller.exception.product.DuplicateProductException;
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

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping(value = "/create")
    public ResponseEntity<ProductResponseDTO> create(@RequestBody ProductRequestDTO request, UriComponentsBuilder uriBuilder) {
        List<IValidator> validators = Arrays.asList(
                new CategoryProductValidator(request),
                new NameProductValidator(request),
                new QuantityProductValidator(request)
        );

        validators.forEach(v -> {
           v.validator();
        });

        Product productAlreadyExist = productService.findByNameAndCategory(request.getName(), request.getCategory());

        if (productAlreadyExist != null) {
            throw new DuplicateProductException("Produto já cadastrado.");
        }

        Product product = productService.create(request);
        ProductResponseDTO productResponseDTO = new ProductDTOMapper().mapDTO(product);

        URI uri = uriBuilder
                .path("/product/{id}")
                .buildAndExpand(product.getProductId())
                .toUri();

        return ResponseEntity.created(uri).body(productResponseDTO);
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
