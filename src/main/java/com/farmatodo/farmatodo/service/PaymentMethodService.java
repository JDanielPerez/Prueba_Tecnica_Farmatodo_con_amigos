package com.farmatodo.farmatodo.service;

import com.farmatodo.farmatodo.model.entity.PaymentMethod;
import com.farmatodo.farmatodo.repository.PaymentMethodRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentMethodService {

    private PaymentMethodRepository paymentMethodRepository;

    public PaymentMethod savePaymentMethod(PaymentMethod paymentMethod){
        return paymentMethodRepository.save(paymentMethod);
    }
}
