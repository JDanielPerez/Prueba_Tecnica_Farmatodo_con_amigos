package com.farmatodo.farmatodo.service;

import com.farmatodo.farmatodo.model.entity.CustomerPaymentMethod;
import com.farmatodo.farmatodo.repository.CustomerPaymentMethodRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerPaymentMethodService {

    private CustomerPaymentMethodRepository customerPaymentMethodRepository;

    public CustomerPaymentMethod saveCustomerPaymentMethod(CustomerPaymentMethod customerPaymentMethod){
        return customerPaymentMethodRepository.save(customerPaymentMethod);
    }

    //metodo para devolver con parte de los datos de la tarjeta de credito
}
