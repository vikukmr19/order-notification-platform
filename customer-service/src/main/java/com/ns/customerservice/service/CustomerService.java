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
//My Approch
//public Customer updateCustomer(Long id, Customer customer) {
//	Optional<Customer> customer1 = customerRepository.findById(id);
//	if(customer1.isPresent()) {
//		Customer existingCustomer = customer1.get();
//		existingCustomer.setName(customer.getName());
//		existingCustomer.setEmail(customer.getEmail());
//		existingCustomer.setPhone(customer.getPhone());
//		//
//		return customerRepository.save(existingCustomer);
//	}
//	else {
//	throw new  CustomerNotFoundException(id);
//	}
//}
//Approch

//Cleaner Approacch
public Customer updateCustomer(Long id, Customer customer) {

    Customer existingCustomer = customerRepository.findById(id)
            .orElseThrow(() -> new CustomerNotFoundException(id));

    existingCustomer.setName(customer.getName());
    existingCustomer.setEmail(customer.getEmail());
    existingCustomer.setPhone(customer.getPhone());

    return customerRepository.save(existingCustomer);
}





//Clearn Approacch


public void deleteCustomer(Long id) {
     
	
	  customerRepository.findById(id)
            .orElseThrow(() -> new CustomerNotFoundException(id));
	  customerRepository.deleteById(id);
}



}
