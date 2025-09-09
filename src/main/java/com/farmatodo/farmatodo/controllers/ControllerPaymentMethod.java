package com.farmatodo.farmatodo.controllers;


import com.farmatodo.farmatodo.models.dtos.PaymentMethodDto;
import com.farmatodo.farmatodo.repositories.PaymentMethodRepository;
import com.farmatodo.farmatodo.services.PaymentMethodService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paymentMethod")
public class ControllerPaymentMethod {

    @Autowired
    private PaymentMethodService paymentMethodService;

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> savePaymentMethod(@RequestBody @Valid PaymentMethodDto paymentMethodDto){
        paymentMethodService.savePaymentMethod(paymentMethodDto);
        return ResponseEntity.ok("Medio de pago registrado con exito");
    }

}
