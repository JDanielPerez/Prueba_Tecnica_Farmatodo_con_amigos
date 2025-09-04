package com.farmatodo.farmatodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository extends JpaRepository<com.farmatodo.farmatodo.model.entity.PaymentMethod, Long> {
}
