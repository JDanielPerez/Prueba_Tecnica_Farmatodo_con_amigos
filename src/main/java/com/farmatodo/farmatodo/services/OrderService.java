package com.farmatodo.farmatodo.services;

import com.farmatodo.farmatodo.models.entities.Order;
import com.farmatodo.farmatodo.repositories.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }
}
