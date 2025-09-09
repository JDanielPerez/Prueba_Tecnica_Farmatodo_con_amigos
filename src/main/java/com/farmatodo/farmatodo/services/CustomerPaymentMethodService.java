package com.farmatodo.farmatodo.services;

import com.farmatodo.farmatodo.models.entities.Customer;
import com.farmatodo.farmatodo.models.entities.CustomerPaymentMethod;
import com.farmatodo.farmatodo.models.entities.PaymentMethod;
import com.farmatodo.farmatodo.repositories.CustomerPaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CustomerPaymentMethodService {

    @Autowired
    private CustomerPaymentMethodRepository customerPaymentMethodRepository;
    @Autowired
    private CustomerService customerService;

    public void saveCustomerPaymentMethod(PaymentMethod paymentMethod){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Customer customer = customerService.findByUserUsername(authentication.getName());
        CustomerPaymentMethod customerPaymentMethod = CustomerPaymentMethod.builder()
                .paymentMethod(paymentMethod)
                .customer(customer)
                .build();
        customerPaymentMethodRepository.save(customerPaymentMethod);
    }
}
