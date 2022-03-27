package com.itboocamp.desafiospring.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PurchaseResponseHistoryDTO {
    private List<PurchaseResponseDTO> purchaseResponseDTOList = new ArrayList<>();
    private BigDecimal total;
}
