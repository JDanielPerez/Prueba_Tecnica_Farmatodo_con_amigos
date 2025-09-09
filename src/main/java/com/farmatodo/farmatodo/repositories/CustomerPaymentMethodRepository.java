package com.farmatodo.farmatodo.repositories;

import com.farmatodo.farmatodo.models.entities.Customer;
import com.farmatodo.farmatodo.models.entities.CustomerPaymentMethod;
import com.farmatodo.farmatodo.models.entities.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerPaymentMethodRepository extends JpaRepository<CustomerPaymentMethod, Long> {
    Optional<CustomerPaymentMethod> findByCustomerAndId(Customer customer, Long paymentMethodId);
}
