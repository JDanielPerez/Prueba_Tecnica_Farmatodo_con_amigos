package com.farmatodo.farmatodo.models.dtos;

import com.farmatodo.farmatodo.models.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetailDTO {

    private Long productId;
    private BigDecimal quantity;
}
