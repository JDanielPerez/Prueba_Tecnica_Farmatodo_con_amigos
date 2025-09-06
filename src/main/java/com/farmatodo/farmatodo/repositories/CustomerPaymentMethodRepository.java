package com.farmatodo.farmatodo.repositories;

import com.farmatodo.farmatodo.models.entities.CustomerPaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerPaymentMethodRepository extends JpaRepository<CustomerPaymentMethod, Long> {
}
