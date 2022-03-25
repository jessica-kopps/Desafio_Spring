package com.itboocamp.desafiospring.dto.mapper;

import com.itboocamp.desafiospring.dto.response.ProductResponseDTO;
import com.itboocamp.desafiospring.dto.response.PurchaseResponseDTO;
import com.itboocamp.desafiospring.dto.resquest.ProductPurchaseRequestDTO;
import com.itboocamp.desafiospring.dto.resquest.PurchaseRequestDTO;
import com.itboocamp.desafiospring.entity.Product;
import com.itboocamp.desafiospring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PurchaseDTOMapper {
//    @Autowired
    private ProductRepository productRepository = new ProductRepository();

    public PurchaseResponseDTO mapDTO(PurchaseRequestDTO purchaseRequestDTO) {
        List<ProductPurchaseRequestDTO> productPurchaseRequestDTOList = purchaseRequestDTO.getArticlesPurchaseRequest();
        ArrayList<ProductResponseDTO> productResponseDTOList = new ArrayList<>();
        BigDecimal totalPrice = BigDecimal.valueOf(0);
        ProductDTOMapper productDTOMapper = new ProductDTOMapper();

        for (ProductPurchaseRequestDTO productPurchase : productPurchaseRequestDTOList) {
            System.out.println(productPurchase);
            ProductResponseDTO productResponseDTO = productDTOMapper.mapDTO(productRepository.findById(productPurchase.getProductId()));
            productResponseDTOList.add(productResponseDTO);
            totalPrice = totalPrice.add(productResponseDTO.getPrice());

        }

        return new PurchaseResponseDTO(productResponseDTOList, totalPrice);

//        PurchaseResponseDTO purchaseResponseDTO = new PurchaseResponseDTO(
//
//        );
    }


}

