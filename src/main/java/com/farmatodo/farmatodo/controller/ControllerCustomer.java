package com.farmatodo.farmatodo.controller;

import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class ControllerCustomer {

    @GetMapping("/ping")
    @ResponseBody
    public String ping(){
        return "Pong";
    }
}
