package com.farmatodo.farmatodo.services;

import com.farmatodo.farmatodo.models.entities.PaymentMethod;
import com.farmatodo.farmatodo.repositories.PaymentMethodRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentMethodService {

    private PaymentMethodRepository paymentMethodRepository;

    public PaymentMethod savePaymentMethod(PaymentMethod paymentMethod){
        return paymentMethodRepository.save(paymentMethod);
    }
}
