package com.farmatodo.farmatodo.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "HISTORY")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = true)
    private String name;

    @Column(name = "REFERENCE", nullable = true)
    private String reference;

    @Column(name = "DATE", nullable = false)
    private LocalDateTime date;
}
