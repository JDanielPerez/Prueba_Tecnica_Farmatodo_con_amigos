package com.farmatodo.farmatodo.controllers;

import com.farmatodo.farmatodo.models.dtos.CustomerDTO;
import com.farmatodo.farmatodo.models.dtos.TokenizeRequestDto;
import com.farmatodo.farmatodo.models.entities.Customer;
import com.farmatodo.farmatodo.services.CustomerService;
import com.farmatodo.farmatodo.services.TokenizationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class ControllerCustomer {

    @Autowired
    private TokenizationService tokenizationService;
    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveCustomer(@RequestBody @Valid CustomerDTO customer){
        customerService.saveCustomer(customer);
        return ResponseEntity.ok("Cliente registrado con exito");
    }

    //tiene errores
    @GetMapping("/get")
    public ResponseEntity<CustomerDTO> getCustomer(Authentication authentication){
        return ResponseEntity.ok(customerService.getCustomerForUsername(authentication.getName()));
    }



    @PostMapping(value = "/token" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> tokenize(@RequestBody @Valid TokenizeRequestDto tokenizeRequest){
        tokenizationService.createToken(tokenizeRequest);
        return ResponseEntity.ok("Medio de pago registrado con exito.");
    }


    @GetMapping("/ping")
    @ResponseBody
    public String ping(){
        return "Pong";
    }
}
