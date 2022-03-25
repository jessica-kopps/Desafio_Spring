package com.itboocamp.desafiospring.dto.resquest;

import com.itboocamp.desafiospring.dto.resquest.ProductRequestDTO;
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
