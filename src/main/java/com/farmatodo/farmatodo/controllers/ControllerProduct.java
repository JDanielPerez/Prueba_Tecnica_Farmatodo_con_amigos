package com.farmatodo.farmatodo.controllers;

import com.farmatodo.farmatodo.models.dtos.ProductDTO;
import com.farmatodo.farmatodo.models.entities.Product;
import com.farmatodo.farmatodo.services.HistoryService;
import com.farmatodo.farmatodo.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ControllerProduct {

    @Autowired
    private ProductService productService;
    @Autowired
    private HistoryService historyService;

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> save(@RequestBody @Valid ProductDTO productDTO){
        productService.saveProduct(productDTO);
        return ResponseEntity.ok("Producto registrado con exito");
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam(required = false) String name, @RequestParam(required = false) String reference) {
        List<Product> results = productService.search(name, reference);
        historyService.saveHistory(name, reference);
        return ResponseEntity.ok(results);
    }

    @GetMapping("/ping")
    @ResponseBody
    public String ping(){
        return "Pong";
    }
}
