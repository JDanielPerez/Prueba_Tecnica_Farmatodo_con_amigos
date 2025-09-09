package com.farmatodo.farmatodo.controllers;

import com.farmatodo.farmatodo.models.dtos.OrderDetailDTO;
import com.farmatodo.farmatodo.models.dtos.PaymentMethodDto;
import com.farmatodo.farmatodo.models.entities.Order;
import com.farmatodo.farmatodo.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class ControllerOrder {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/addProduct")
    public ResponseEntity<String> addProduct(@RequestBody @Valid OrderDetailDTO orderDetailDTO){
        orderService.validateOrder(orderDetailDTO);
        return ResponseEntity.ok("Producto adicionado con exito");
    }

    @PostMapping(value = "/pay")
    public ResponseEntity<String> payOrder(@RequestParam(required = true) Long paymentMethodId,@RequestParam(required = true) Long orderId){
        orderService.payOrder(paymentMethodId, orderId);
        return ResponseEntity.ok("Pago realizado con exito");
    }


    @GetMapping("/ping")
    @ResponseBody
    public String ping(){
        return "Pong";
    }
}
