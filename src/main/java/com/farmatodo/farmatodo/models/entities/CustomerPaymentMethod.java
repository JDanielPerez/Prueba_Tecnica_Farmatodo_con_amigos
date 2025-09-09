package com.farmatodo.farmatodo.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "CUSTOMER_PAYMENT_METHOD")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerPaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "PAYMENT_METHOD_ID", nullable = false)
    private PaymentMethod paymentMethod;
}
