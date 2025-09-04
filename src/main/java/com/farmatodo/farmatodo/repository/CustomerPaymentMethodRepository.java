package com.farmatodo.farmatodo.repository;

import com.farmatodo.farmatodo.model.entity.CustomerPaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerPaymentMethodRepository extends JpaRepository<CustomerPaymentMethod, Long> {
}
