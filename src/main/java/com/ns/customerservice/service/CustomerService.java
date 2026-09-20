package com.ns.customerservice.service;

 import java.util.List;

import org.springframework.stereotype.Service;

import com.ns.customerservice.entity.Customer;
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



}
