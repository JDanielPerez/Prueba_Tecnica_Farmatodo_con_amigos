package com.farmatodo.farmatodo.controllers;


import com.farmatodo.farmatodo.models.dtos.UserRegisterDTO;
import com.farmatodo.farmatodo.services.UserService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> register(@Valid @RequestBody UserRegisterDTO userRegisterDTO){
        userService.saveUser(userRegisterDTO);
        return ResponseEntity.ok("Registrado con exito");
    }
}
