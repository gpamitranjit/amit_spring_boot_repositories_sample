package com.amit.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.amit.app.exception.CustomerNotFoundException;
import com.amit.app.model.dto.CustomerDTO;
import com.amit.app.model.repository.Customer;
import com.amit.app.repository.jpa.CustomerRepository;
import com.amit.app.transformation.CustomerToCustomerDTOTransformer;

@Service
public class CustomerService {

	private CustomerRepository customerRepository;
	private CustomerToCustomerDTOTransformer customerToCustomerDTOTransformer;
	
	@Autowired
	public CustomerService(CustomerRepository customerRepository, CustomerToCustomerDTOTransformer customerToCustomerDTOTransformer) {
		this.customerRepository = customerRepository;
		this.customerToCustomerDTOTransformer = customerToCustomerDTOTransformer;
	}
	
	public List<CustomerDTO> getAllCustomers() {
		Iterable<Customer> iterableCustomers = customerRepository.findAll();
		List<Customer> customers = new ArrayList<>();
		iterableCustomers.forEach(customers::add);
		return customerToCustomerDTOTransformer.transform(customers);
	}
	
	public List<CustomerDTO> getAllSortedCustomers(Sort sort) {
		Iterable<Customer> iterableCustomers = customerRepository.findAll(sort);
		List<Customer> customers = new ArrayList<>();
		iterableCustomers.forEach(customers::add);
		return customerToCustomerDTOTransformer.transform(customers);
	}

	public List<CustomerDTO> getPaginatedCustomers(Pageable pageable) {
		Iterable<Customer> iterableCustomers = customerRepository.findAll(pageable);
		List<Customer> customers = new ArrayList<>();
		iterableCustomers.forEach(customers::add);
		return customerToCustomerDTOTransformer.transform(customers);
	}
	
	public CustomerDTO storeCustomer(com.amit.app.model.dto.CustomerDTO customerDTO) {
		
		Customer managedCustomerEntity = new Customer();
		managedCustomerEntity.setId(customerDTO.getId());
		managedCustomerEntity.setFirstName(customerDTO.getFirstName());
		managedCustomerEntity.setLastName(customerDTO.getLastName());
		
		Customer savedCustomerObj = customerRepository.save(managedCustomerEntity);
		customerDTO.setId(savedCustomerObj.getId());
		
		return customerDTO; 
	}
	
	public com.amit.app.model.dto.CustomerDTO findById(Long customerId) {
		Optional<Customer> customer = customerRepository.findById(customerId);
		if (!customer.isPresent()) {
			throw new CustomerNotFoundException(customerId, "Coudln't find customer details");
		}
		return customerToCustomerDTOTransformer.transform(customer.get());
	}
}