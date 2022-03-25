package com.itboocamp.desafiospring.controller;

import com.itboocamp.desafiospring.dto.mapper.PurchaseDTOMapper;
import com.itboocamp.desafiospring.dto.response.PurchaseResponseDTO;
import com.itboocamp.desafiospring.dto.resquest.PurchaseRequestDTO;
import com.itboocamp.desafiospring.entity.Purchase;
import com.itboocamp.desafiospring.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/purchase-request/")
    public ResponseEntity<PurchaseResponseDTO> createPurchase(@RequestBody PurchaseRequestDTO purchaseRequestDTO){
        PurchaseDTOMapper purchaseDTOMapper = new PurchaseDTOMapper();
        Purchase purchase = purchaseService.getPurchase(purchaseRequestDTO);
        return ResponseEntity.ok(purchaseDTOMapper.mapDTO(purchase));
    }
}
