package com.amit.app.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amit.app.model.repository.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
