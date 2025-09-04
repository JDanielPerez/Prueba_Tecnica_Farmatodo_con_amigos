package com.farmatodo.farmatodo.service;

import com.farmatodo.farmatodo.model.entity.OrderDetail;
import com.farmatodo.farmatodo.repository.OrderDetailRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService {

    private OrderDetailRepository orderDetailRepository;

    public OrderDetail saveOrderDetail(OrderDetail orderDetail){
        return orderDetailRepository.save(orderDetail);
    }
}
