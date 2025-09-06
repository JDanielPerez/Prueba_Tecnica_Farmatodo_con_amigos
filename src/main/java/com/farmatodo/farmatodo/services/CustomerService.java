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

    public CustomerDTO getCustomerForUsername(String username){
        Optional<Customer> customerOpt = customerRepository.findByUserUsername(username);

        if(!customerOpt.isPresent()){
            throw new IllegalArgumentException("El cliente no existe para este usuario");
        }

        Customer customer = customerOpt.get();

        return CustomerDTO.builder()
                .identificationType(customer.getIdentificationType())
                .identificationNumber(customer.getIdentificationNumber())
                .name(customer.getName())
                .phoneNumber(customer.getPhoneNumber())
                .email(customer.getEmail())
                .country(customer.getCountry())
                .city(customer.getCity())
                .address(customer.getAddress())
                .build();
    }

    /*
     * Valida que los datos de contacto del cliente sean únicos antes de su registro.
     * Este método verifica que el correo electrónico y el número de teléfono del cliente
     * no estén previamente registrados en la base de datos. Si alguno ya existe, lanza
     * una excepción indicando el conflicto.
     *
     * @param customer Objeto {@link Customer} que contiene los datos a validar.
     * @throws IllegalArgumentException Si el correo electrónico o el número de teléfono ya están registrados.
     */
    private void validateCustomer(Customer customer){

        //adicional deberia tener otra condición que valide si el formato del correo electronico es valido?
        if(customerRepository.existsByEmail(customer.getEmail())){
            throw new IllegalArgumentException("Este correo electronico ya se encuentra registrado.");
        }
        if(customerRepository.existsByPhoneNumber(customer.getPhoneNumber())){
            throw new IllegalArgumentException("Este número celular ya se encuentra registrado.");
        }
    }
}
