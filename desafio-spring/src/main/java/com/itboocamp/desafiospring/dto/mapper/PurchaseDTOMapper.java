package com.itboocamp.desafiospring.dto.mapper;

import com.itboocamp.desafiospring.dto.response.ProductResponseDTO;
import com.itboocamp.desafiospring.dto.response.PurchaseResponseDTO;
import com.itboocamp.desafiospring.dto.resquest.ProductPurchaseRequestDTO;
import com.itboocamp.desafiospring.dto.resquest.PurchaseRequestDTO;
import com.itboocamp.desafiospring.entity.Product;
import com.itboocamp.desafiospring.repository.ProductRepository;
import com.itboocamp.desafiospring.controller.exception.purchase.NotFoundException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PurchaseDTOMapper {
    private ProductRepository productRepository = new ProductRepository();

    public PurchaseResponseDTO mapDTO(PurchaseRequestDTO purchaseRequestDTO) {
        ProductDTOMapper productDTOMapper = new ProductDTOMapper();

        List<ProductPurchaseRequestDTO> productPurchaseRequestDTOList = purchaseRequestDTO.getArticlesPurchaseRequest();
        ArrayList<ProductResponseDTO> productResponseDTOList = new ArrayList<>();

        BigDecimal totalPrice = BigDecimal.valueOf(0);

        for (ProductPurchaseRequestDTO productPurchase : productPurchaseRequestDTOList) {
            Product product = productRepository.findById(productPurchase.getProductId());
            if (product == null){
                throw new NotFoundException("Product not found! Purchase declined.");
            }
            ProductResponseDTO productResponseDTO = productDTOMapper.mapDTO(product);
            productResponseDTOList.add(productResponseDTO);

            totalPrice = totalPrice.add(
                    BigDecimal.valueOf(productResponseDTO.getQuantity())
                    .multiply(productResponseDTO.getPrice()));
        }

        return new PurchaseResponseDTO(productResponseDTOList, totalPrice);
    }


}

