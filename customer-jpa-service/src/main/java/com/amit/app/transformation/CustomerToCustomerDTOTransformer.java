package com.amit.app.transformation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.amit.app.model.dto.CustomerDTO;
import com.amit.app.model.repository.Customer;

@Component
public class CustomerToCustomerDTOTransformer implements TypeSafeTransformer<Customer, com.amit.app.model.dto.CustomerDTO> {

	@Override
	public com.amit.app.model.dto.CustomerDTO transform(Customer customer) {
		if (customer == null) {
			return null;
		}
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setId(customer.getId());
		customerDTO.setFirstName(customer.getFirstName());
		customerDTO.setLastName(customer.getLastName());
		return customerDTO;
	}
	
	@Override
	public List<CustomerDTO> transform(List<Customer> customers) {
		return customers.parallelStream()
				.map((customer) -> new CustomerDTO(customer.getId(), customer.getFirstName(), customer.getLastName()))
				.collect(Collectors.toList());
	}

}
