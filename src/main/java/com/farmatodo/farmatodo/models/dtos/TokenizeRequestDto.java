package com.farmatodo.farmatodo.models.dtos;

import jakarta.validation.constraints.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TokenizeRequestDto {

    @NotBlank(message = "El número de tarjeta no puede estar vacio.")
    @Pattern(regexp = "\\d{13,19}", message = "El número de tarjeta debe tener entre 13 y 19 dígitos")
    private String cardNumber;

    @NotBlank(message = "El cvc no puede estar vacio.")
    @Pattern(regexp = "\\d{3,4}", message = "El cvc debe tener entre 3 y 4 dígitos")
    private String cvc;

    //falta validar que la fecha no sea inferior a la actual
    @Min(value = 1, message = "El mes debe estar entre 1 y 12")
    @Max(value = 12, message = "El mes debe estar entre 1 y 12")
    private int expirationMonth;

    @Min(value = 2025, message = "El año debe ser válido y superior al año actual")
    private int expirationYear;

    @Size(max = 128, message = "El nombre no puede exceder 128 caracteres")
    private String ownerCardName;
}
