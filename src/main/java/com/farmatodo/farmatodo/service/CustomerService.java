package com.farmatodo.farmatodo.service;

import com.farmatodo.farmatodo.model.entity.Customer;
import com.farmatodo.farmatodo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private  CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer){
        validateCustomer(customer);
        return customerRepository.save(customer);
    }


    /*
     * Valida que los datos de contacto del cliente sean únicos antes de su registro.
     * <p>
     * Este método verifica que el correo electrónico y el número de teléfono del cliente
     * no estén previamente registrados en la base de datos. Si alguno ya existe, lanza
     * una excepción indicando el conflicto.
     * </p>
     *
     * @param customer Objeto {@link Customer} que contiene los datos a validar.
     * @throws IllegalArgumentException Si el correo electrónico o el número de teléfono ya están registrados.
     */
    private void validateCustomer(Customer customer){

        if(customerRepository.existByMail(customer.getEmail())){
            throw new IllegalArgumentException("Este correo electronico ya se encuentra registrado.");
        }
        if(customerRepository.existByPhoneNumber(customer.getPhoneNumber())){
            throw new IllegalArgumentException("Este número celular ya se encuentra registrado.");
        }
    }
}
