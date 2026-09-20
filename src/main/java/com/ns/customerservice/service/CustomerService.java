package com.ns.customerservice.service;

 import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ns.customerservice.entity.Customer;
import com.ns.customerservice.exception.CustomerNotFoundException;
import com.ns.customerservice.repository.CustomerRepository;

@Service
public class CustomerService {


private final CustomerRepository customerRepository;

public CustomerService(CustomerRepository customerRepository) {
	 
	this.customerRepository = customerRepository;
}

public Customer createCustomer(Customer customer) {
	
	return customerRepository.save(customer);
    // save customer
}
public List<Customer> getcustomer(){
	
	return customerRepository.findAll();
	
}
public Customer getCustomerById(Long id) {
    return customerRepository.findById(id)
            .orElseThrow(() -> new CustomerNotFoundException(id));
}

}
