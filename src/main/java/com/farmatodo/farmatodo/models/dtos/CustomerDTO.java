package com.farmatodo.farmatodo.models.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {


    @NotBlank(message = "El tipo de identificacion es obligatorio.")
    private String  identificationType;

    @NotBlank(message = "El numero de identificacion es obligatorio.")
    @Pattern(regexp = "\\d+", message = "El número de identificación debe contener solo dígitos.")
    private String  identificationNumber;

    @NotBlank(message = "El nombre es obligatorio.")
    private String  name;

    @NotBlank(message = "El numero de telefono es obligatorio.")
    @Pattern(regexp = "\\d{10}", message = "El número de teléfono debe tener exactamente 10 dígitos.")
    private String  phoneNumber;

    @NotBlank(message = "El correo es obligatorio.")
    @Email(message = "El correo debe tener un formato válido.")
    private String  email;

    private String  country;

    private String  city;

    private String  address;
}
