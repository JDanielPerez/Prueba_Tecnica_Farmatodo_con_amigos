package com.farmatodo.farmatodo.controller;

import com.farmatodo.farmatodo.model.dto.TokenizeRequest;
import com.farmatodo.farmatodo.service.TokenizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/customers")
public class ControllerCustomer {

    @Autowired
    private TokenizationService tokenizationService;

    //@GetMapping("/tokens")
    @PostMapping(value = "/tokens" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> tokenize(@RequestBody @Validated TokenizeRequest tokenizeRequest){
        tokenizationService.createToken(tokenizeRequest);
        return ResponseEntity.ok("Medio de pago creado con exito.");
    }


    @GetMapping("/ping")
    @ResponseBody
    public String ping(){
        return "Pong";
    }
}
