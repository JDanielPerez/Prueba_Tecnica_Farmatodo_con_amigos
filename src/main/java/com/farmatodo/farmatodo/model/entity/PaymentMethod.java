package com.farmatodo.farmatodo.model.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "PAYMENT_METHODS")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethod {

    public PaymentMethod(String token){
        this.token = token;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TOKEN", nullable = false)
    private String token;

   /* @Column(name = "CARD_TYPE", nullable = false, length = 20)
    private String cardType;

    @Column(name = "CARD_NUMBER", nullable = false, length = 16)
    private String cardNumber;

    @Column(name = "CARD_VERIFICATION_CODE", nullable = false, length = 4)
    private String cardVerificationCode;

    @Column(name = "EXPIRATION_DATE_YEAR", nullable = false)
    private int expirationDateYear;

    @Column(name = "EXPIRATION_DATE_MONTH", nullable = false)
    private int expirationDatemMonth;

    @Column(name = "OWNER_NAME" , nullable = true, length = 100)
    private String ownerName;
*/

}
