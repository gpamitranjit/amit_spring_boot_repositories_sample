package com.amit.app.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.amit.app.model.repository.Customer;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

}