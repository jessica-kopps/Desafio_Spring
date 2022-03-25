package com.itboocamp.desafiospring.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseRequestDTO {
    private List<ProductPurchaseRequestDTO> articlesPurchaseRequest;
}
