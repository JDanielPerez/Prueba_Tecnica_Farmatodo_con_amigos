package com.farmatodo.farmatodo.repository;

import com.farmatodo.farmatodo.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    boolean existByMail(String mail);
    boolean existByPhoneNumber(String phoneNumber);
}
