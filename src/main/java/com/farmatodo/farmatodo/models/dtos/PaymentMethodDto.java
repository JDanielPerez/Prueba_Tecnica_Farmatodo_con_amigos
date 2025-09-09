package com.farmatodo.farmatodo.models.dtos;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentMethodDto {

    @NotBlank(message = "El número de tarjeta no puede estar vacio.")
    @Pattern(regexp = "\\d{13,19}", message = "El número de tarjeta debe tener entre 13 y 19 dígitos")
    private String cardNumber;

    @NotBlank(message = "El cvc no puede estar vacio.")
    @Pattern(regexp = "\\d{3,4}", message = "El cvc debe tener entre 3 y 4 dígitos")
    private String cvc;

    @Min(value = 1, message = "El mes debe estar entre 1 y 12")
    @Max(value = 12, message = "El mes debe estar entre 1 y 12")
    private int expirationMonth;

    @Min(value = 1000, message = "El año debe tener 4 digitos")
    @Max(value = 3000, message = "El año debe tener 4 digitos")
    private int expirationYear;

    @Size(max = 128, message = "El nombre no puede exceder 128 caracteres")
    private String ownerCardName;
}
