package com.farmatodo.farmatodo.services;

import com.farmatodo.farmatodo.models.dtos.UserRegisterDTO;
import com.farmatodo.farmatodo.models.entities.Customer;
import com.farmatodo.farmatodo.models.entities.User;
import com.farmatodo.farmatodo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User saveUser(UserRegisterDTO userRegisterDTO){
        if(userRepository.existsByUsername(userRegisterDTO.getUsername())){
            throw new IllegalArgumentException("Ya existe este nombre de usuario");
        }

        User user = User.builder()
                .username(userRegisterDTO.getUsername())
                .password(passwordEncoder.encode(userRegisterDTO.getPassword()))
                .build();


        Customer customer = Customer.builder()
                .user(user)
                .identificationType(userRegisterDTO.getIdentificationType())
                .identificationNumber(userRegisterDTO.getIdentificationNumber())
                .name(userRegisterDTO.getName())
                .email(userRegisterDTO.getEmail())
                .phoneNumber(userRegisterDTO.getPhoneNumber())
                .city(userRegisterDTO.getCity())
                .country(userRegisterDTO.getCountry())
                .address(userRegisterDTO.getAddress())
                .build();

        user.setCustomer(customer);

        return userRepository.save(user);
    }



}
