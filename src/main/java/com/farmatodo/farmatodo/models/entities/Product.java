package com.farmatodo.farmatodo.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCTS")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "DESCRIPTION", nullable = true, length = 254)
    private String description;

    @Column(name = "REFERENCE", nullable = false, unique = true,length = 100)
    private String reference;

    @Column(name = "QUANTITY", nullable = false)
    private BigDecimal quantity;

    @Column(name = "PRICE", nullable = false)
    private BigDecimal price;

    @Column(name = "ACTIVE")
    private boolean active;
}
