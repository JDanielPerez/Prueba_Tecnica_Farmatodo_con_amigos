package com.farmatodo.farmatodo.services;

import com.farmatodo.farmatodo.models.entities.Order;
import com.farmatodo.farmatodo.repositories.OrderDetailRepository;
import com.farmatodo.farmatodo.repositories.OrderRepository;
import com.farmatodo.farmatodo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;

}
