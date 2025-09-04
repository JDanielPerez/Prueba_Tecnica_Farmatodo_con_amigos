package com.farmatodo.farmatodo.service;

import com.farmatodo.farmatodo.model.entity.Product;
import com.farmatodo.farmatodo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    //FALTA UN METODO QUE ME PERMITA BUSCAR PRODUCTOS EN LA BASE DE DATOS CON DIVERSOS FILTROS
    //DEBO EXPLORAR LA OPCION DE USAR LA ANOTACION @QUERY O PREGUNTAR BIEN QUE PODRIA UTILIZAR AQUI
    //FALTA TAMBIEN LO DE ALMACENAR LAS BUSQUEDAS REALIZADAS DE MANERA ASINCRONA EN LA BD




}
