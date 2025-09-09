package com.farmatodo.farmatodo.models.entities;

import com.farmatodo.farmatodo.models.enums.OrderStatus;
import com.farmatodo.farmatodo.models.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ORDERS")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {


    //DEBERIA COLOCAR UNA COLUMNA PARA VALIDAR LA CANTIDAD DE INTENTOS A LA HORA DE HACER UN PAGO?
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    //CLAVE PRIMARIA COMPUESTA CONSULTARLA PARA MAÑANA MIERCOLES
    //FALTA LA COLECCION DONDE SE ALMACENAN LOS MEDIOS DE PAGO
    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetailsList;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_PAYMENT_METHOD_ID")
    private CustomerPaymentMethod customerPaymentMethodId;

    //Lo voy a dejar asi y en el momento que vaya a confirmar el pago lo vuelvo obligatorio al guardar
    @Column(name = "DELIVERY_ADDRESS", nullable = true, length = 100)
    private String deliveryAddress;

    @Column(name = "TOTAL_VALUE", nullable = false)
    private BigDecimal totalValue;

    @Enumerated(EnumType.STRING)
    @Column(name = "PAYMENT_STATUS")
    private PaymentStatus paymentStatus;

    @Column(name = "PAYMENT_DATE")
    private LocalDateTime paymentDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "ORDER_STATUS", nullable = false, length = 20)
    private OrderStatus orderStatus;

    @Column(name = "PAYMENT_ATTEMPS", nullable = false, columnDefinition = "int default 0")
    private int paymentAttempts;


}
