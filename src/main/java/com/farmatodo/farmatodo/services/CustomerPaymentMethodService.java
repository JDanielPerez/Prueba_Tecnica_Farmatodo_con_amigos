package com.farmatodo.farmatodo.services;

import com.farmatodo.farmatodo.models.entities.CustomerPaymentMethod;
import com.farmatodo.farmatodo.repositories.CustomerPaymentMethodRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerPaymentMethodService {

    private CustomerPaymentMethodRepository customerPaymentMethodRepository;

    public CustomerPaymentMethod saveCustomerPaymentMethod(CustomerPaymentMethod customerPaymentMethod){
        return customerPaymentMethodRepository.save(customerPaymentMethod);
    }

    //metodo para devolver con parte de los datos de la tarjeta de credito
}
