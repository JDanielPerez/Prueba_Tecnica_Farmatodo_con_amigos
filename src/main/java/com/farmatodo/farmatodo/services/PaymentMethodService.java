package com.farmatodo.farmatodo.services;

import com.farmatodo.farmatodo.models.dtos.PaymentMethodDto;
import com.farmatodo.farmatodo.models.entities.PaymentMethod;
import com.farmatodo.farmatodo.repositories.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PaymentMethodService {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;
    @Autowired
    private CustomerPaymentMethodService customerPaymentMethodService;


    public PaymentMethod savePaymentMethod(PaymentMethodDto paymentMethodDto){

        validatePaymentMethod(paymentMethodDto);

        PaymentMethod paymentMethod = PaymentMethod.builder()
                .cardNumber(paymentMethodDto.getCardNumber())
                .cvc(paymentMethodDto.getCvc())
                .ownerCardName(paymentMethodDto.getOwnerCardName())
                .expirationYear(paymentMethodDto.getExpirationYear())
                .expirationMonth(paymentMethodDto.getExpirationMonth())
                .build();

        paymentMethodRepository.save(paymentMethod);
        customerPaymentMethodService.saveCustomerPaymentMethod(paymentMethod);

        return paymentMethod;
    }

    public void validatePaymentMethod(PaymentMethodDto paymentMethodDto){

        LocalDate now = LocalDate.now();
        if(paymentMethodDto.getExpirationYear() < now.getYear()){
            throw new IllegalArgumentException("El año de la tarjeta de credito no puede ser inferior al año actual.");
        }
        else if(paymentMethodDto.getExpirationYear() == now.getYear()){
            if(paymentMethodDto.getExpirationMonth() < now.getMonthValue()){
                throw new IllegalArgumentException("El mes de la tarjeta de credito no puede ser inferior al mes actual");
            }
        }
    }
}
