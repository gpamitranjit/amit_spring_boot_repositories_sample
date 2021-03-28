package com.amit.app.controller;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amit.app.model.dto.CustomerDTO;
import com.amit.app.service.CustomerService;

@RestController
@RequestMapping(path = {"/v1.0"})
public class CustomerController {

	private CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@RequestMapping(path = {"/customers/{customerId}"}, method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public CustomerDTO getCustomer(@PathVariable("customerId") Long customerId) {
		return customerService.findById(customerId);
	}
	
	@RequestMapping(path = {"/customer"}, method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public CustomerDTO storeCustomer(@RequestBody CustomerDTO customer) {
		return customerService.storeCustomer(customer);
	}
	
	@RequestMapping(path = {"/customers"}, method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<CustomerDTO> getAllCustomers() {
		return customerService.getAllCustomers();
	}
	
	@RequestMapping(path = {"/customers/sorted"}, method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<CustomerDTO> getAllSortedCustomers(Sort sort) {
		return customerService.getAllSortedCustomers(sort);
	}
	
	@RequestMapping(path = {"/customers/paginated"}, method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<CustomerDTO> getAllPaginatedCustomers(Pageable pageable) {
		return customerService.getPaginatedCustomers(pageable);
	}
}