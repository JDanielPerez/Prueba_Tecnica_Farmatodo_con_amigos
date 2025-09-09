package com.farmatodo.farmatodo.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;


@Entity
@Table(name = "PAYMENT_METHODS")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CARD_NUMBER", nullable = false, unique = true)
    private String cardNumber;

    @Column(name = "CVC", nullable = false)
    private String cvc;

    @Column(name = "EXPIRATION_MONTH", nullable = false)
    private int expirationMonth;

    @Column(name = "EXPIRATION_YEAR", nullable = false)
    private int expirationYear;

    @Column(name = "OWNER_CARD_NAME", nullable = false)
    private String ownerCardName;


}
