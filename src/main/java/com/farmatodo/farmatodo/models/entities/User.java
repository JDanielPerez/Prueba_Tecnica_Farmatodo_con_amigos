package com.farmatodo.farmatodo.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "USERS")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Customer customer;

    @Column(name = "USERNAME", nullable = false, length = 40)
    private String username;

    @Column(name = "PASSWORD", nullable = false, length = 255)
    private String password;
}
