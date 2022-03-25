package com.itboocamp.desafiospring.controller;

import com.itboocamp.desafiospring.dto.mapper.PurchaseDTOMapper;
import com.itboocamp.desafiospring.dto.response.PurchaseResponseDTO;
import com.itboocamp.desafiospring.dto.resquest.PurchaseRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseController {

    @PostMapping("/purchase-request/")
    public ResponseEntity<PurchaseResponseDTO> createPurchase(@RequestBody PurchaseRequestDTO purchaseRequestDTO){
        PurchaseResponseDTO purchaseResponseDTO = new PurchaseDTOMapper().mapDTO(purchaseRequestDTO);
        return ResponseEntity.ok(purchaseResponseDTO);
    }
}
