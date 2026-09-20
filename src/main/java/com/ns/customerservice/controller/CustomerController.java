package com.ns.customerservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ns.customerservice.entity.Customer;
import com.ns.customerservice.service.CustomerService;

import jakarta.validation.Valid;

@RestController
public class CustomerController {
	

public final CustomerService customerService;

private CustomerController(CustomerService customerService) {
	 
	this.customerService = customerService;
}

@PostMapping("/customers")
public Customer createCustomer(@Valid @RequestBody Customer customer) {
    return customerService.createCustomer(customer);
}
@GetMapping("/customers")
public List<Customer> getcustomer (){
	return customerService.getcustomer();
}

@GetMapping("/customers/{id}")
public Customer getcustomerbyid (@PathVariable Long id) {
	return customerService.getCustomerById(id);
}


	

}
