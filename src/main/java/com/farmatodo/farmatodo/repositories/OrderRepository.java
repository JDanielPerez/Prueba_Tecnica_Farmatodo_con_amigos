package com.farmatodo.farmatodo.repositories;

import com.farmatodo.farmatodo.models.entities.Customer;
import com.farmatodo.farmatodo.models.entities.Order;
import com.farmatodo.farmatodo.models.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findByCustomerAndOrderStatus(Customer customer, OrderStatus orderStatus);

}
