package com.farmatodo.farmatodo.models.dtos;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

    @NotBlank(message = "El nombre es obligatorio.")
    private String name;

    private String description;

    @NotBlank(message = "La referencia es obligatoria.")
    private String reference;

    @NotNull(message = "La cantidad es obligatoria.")
    @DecimalMin(value = "0.01", inclusive = true, message = "La cantidad debe ser mayor que 0.")
    private BigDecimal quantity;

    @NotNull(message = "El precio es obligatorio.")
    @DecimalMin(value = "0.01", inclusive = true, message = "El precio debe ser mayor que 0.")
    private BigDecimal price;

    private boolean active;
}
