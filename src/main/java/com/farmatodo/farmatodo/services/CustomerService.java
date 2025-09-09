package com.farmatodo.farmatodo.services;

import com.farmatodo.farmatodo.models.dtos.CustomerDTO;
import com.farmatodo.farmatodo.models.entities.Customer;
import com.farmatodo.farmatodo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private  CustomerRepository customerRepository;

    public void saveCustomer(CustomerDTO customerDTO){

        Customer customer = Customer.builder()
                .identificationType(customerDTO.getIdentificationType())
                .identificationNumber(customerDTO.getIdentificationNumber())
                .name(customerDTO.getName())
                .phoneNumber(customerDTO.getPhoneNumber())
                .email(customerDTO.getEmail())
                .country(customerDTO.getCountry())
                .city(customerDTO.getCity())
                .address(customerDTO.getAddress())
                .build();

        validateCustomer(customer);
        customerRepository.save(customer);
    }

    public Customer findByUserUsername(String username){
        Optional<Customer> customerOpt = customerRepository.findByUserUsername(username);

        if(customerOpt.isEmpty()){
            throw new IllegalArgumentException("El cliente no existe para este usuario");
        }

        return customerOpt.get();
    }

    private void validateCustomer(Customer customer){

        if(customerRepository.existsByEmail(customer.getEmail())){
            throw new IllegalArgumentException("Este correo electronico ya se encuentra registrado.");
        }
        if(customerRepository.existsByPhoneNumber(customer.getPhoneNumber())){
            throw new IllegalArgumentException("Este número celular ya se encuentra registrado.");
        }
    }
}
