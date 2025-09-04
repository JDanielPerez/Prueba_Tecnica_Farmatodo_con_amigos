package com.farmatodo.farmatodo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/orders")
public class ControllerOrder {

    @GetMapping("/ping")
    @ResponseBody
    public String ping(){
        return "Pong";
    }
}
