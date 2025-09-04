package com.farmatodo.farmatodo.service;

import com.farmatodo.farmatodo.model.entity.Order;
import com.farmatodo.farmatodo.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }
}
