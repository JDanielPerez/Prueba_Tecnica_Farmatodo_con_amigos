package com.farmatodo.farmatodo.model.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "CUSTOMERS")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    //CLAVE PRIMARIA COMPUESTA CONSULTARLA PARA MAÑANA MIERCOLES
    //FALTA LA COLECCION DONDE SE ALMACENAN LOS MEDIOS DE PAGO
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    //PREGUNTA DEBERIA PONER QUE SE ELIMINEN EN CASCADA CUANDO SE ELIMINE UN CLIENTE
    //PROBABLEMENTE SI PERO IGUAL QUIERO CONFIRMAR
    @OneToMany(mappedBy = "customer")
    private List<CustomerPaymentMethod> paymentMethodList;

    @Column(name = "IDENTIFICATION_TYPE", nullable = false, length = 40)
    private String identificationType;

    @Column(name = "IDENTIFICATION_NUMBER", nullable = false, length = 15)
    private String identificationNumber;

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "PHONE_NUMBER", nullable = false, unique = true,length = 10)
    private String phoneNumber;

    @Column(name = "EMAIL", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "COUNTRY", nullable = false, length = 40)
    private String country;

    @Column(name = "CITY", nullable = false, length = 40)
    private String city;

}
