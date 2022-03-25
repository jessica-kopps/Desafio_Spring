package com.itboocamp.desafiospring.service;

import com.itboocamp.desafiospring.controller.exception.purchase.InsufficientQuantityException;
import com.itboocamp.desafiospring.controller.exception.purchase.NotFoundException;
import com.itboocamp.desafiospring.dto.mapper.ProductDTOMapper;
import com.itboocamp.desafiospring.dto.response.ProductResponseDTO;
import com.itboocamp.desafiospring.dto.response.PurchaseResponseDTO;
import com.itboocamp.desafiospring.dto.resquest.ProductPurchaseRequestDTO;
import com.itboocamp.desafiospring.dto.resquest.PurchaseRequestDTO;
import com.itboocamp.desafiospring.entity.Product;
import com.itboocamp.desafiospring.entity.Purchase;
import com.itboocamp.desafiospring.entity.mapper.EntityMapper;
import com.itboocamp.desafiospring.repository.ProductProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseService {
    @Autowired
    private ProductProductRepository productRepository;

    public Purchase getPurchase(PurchaseRequestDTO purchaseRequestDTO) {
        List<ProductPurchaseRequestDTO> productPurchaseRequestDTOList = purchaseRequestDTO.getArticlesPurchaseRequest();
        ArrayList<Product> products = new ArrayList<>();

        BigDecimal totalPrice = BigDecimal.valueOf(0);



        for (ProductPurchaseRequestDTO productPurchase : productPurchaseRequestDTOList) {
            Product product = productRepository.findById(productPurchase.getProductId());
            if (product == null){
                throw new NotFoundException("Product not found! Purchase declined.");
            }

            if (product.getQuantity() < productPurchase.getQuantity()) {
                throw new InsufficientQuantityException("Insufficient product quantity! Purchase declined.");
            }

            product.setQuantity(product.getQuantity() - productPurchase.getQuantity());
            productRepository.updateById(product.getProductId(), product);
            product.setQuantity(productPurchase.getQuantity());

            products.add(product);
            totalPrice = totalPrice.add(
                    BigDecimal.valueOf(productPurchase.getQuantity())
                            .multiply(product.getPrice()));
        }
        return new Purchase(products, totalPrice);
    }

}
