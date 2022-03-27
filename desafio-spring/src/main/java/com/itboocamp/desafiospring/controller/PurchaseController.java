package com.itboocamp.desafiospring.controller;

import com.itboocamp.desafiospring.dto.mapper.PurchaseDTOMapper;
import com.itboocamp.desafiospring.dto.response.PurchaseResponseDTO;
import com.itboocamp.desafiospring.dto.request.PurchaseRequestDTO;
import com.itboocamp.desafiospring.dto.response.PurchaseResponseHistoryDTO;
import com.itboocamp.desafiospring.entity.Purchase;
import com.itboocamp.desafiospring.service.PurchaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api(value = "Compras")
@RequestMapping(value = "purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @ApiOperation(value = "Faça uma compra por esta requisição")
    @PostMapping("/request")
    public ResponseEntity<PurchaseResponseDTO> createPurchase(@RequestBody PurchaseRequestDTO purchaseRequestDTO){
        PurchaseDTOMapper purchaseDTOMapper = new PurchaseDTOMapper();
        Purchase purchase = purchaseService.getPurchase(purchaseRequestDTO);
        return ResponseEntity.ok(purchaseDTOMapper.mapDTO(purchase));
    }

    @GetMapping()
    @ApiOperation(value = "Liste todas as compras realizadas por esta requisição")
    public ResponseEntity<PurchaseResponseHistoryDTO> findAll() {
        PurchaseDTOMapper purchaseDTOMapper = new PurchaseDTOMapper();
        PurchaseResponseHistoryDTO historyResponse = new PurchaseResponseHistoryDTO();
        historyResponse.setTotal(new BigDecimal(0));
        historyResponse.setPurchaseResponseDTOList(purchaseService.getAllPurchases().stream()
                        .map( purchase -> {
                            historyResponse.setTotal(historyResponse.getTotal().add(purchase.getTotalPrice()));
                            return purchaseDTOMapper.mapDTO(purchase);
                        }).collect(Collectors.toList()));
        return ResponseEntity.ok(historyResponse);
    }
}
