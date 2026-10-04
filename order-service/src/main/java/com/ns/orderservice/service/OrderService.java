package com.ns.orderservice.service;

import org.springframework.stereotype.Service;
import com.ns.orderservice.entity.Order;

import com.ns.orderservice.repository.OrderRepository;

 
@Service
public class OrderService {

	private final OrderRepository orderRepository;
	private final CustomerClient customerClient;


	public OrderService(OrderRepository orderRepository, CustomerClient customerClient) {
		 
		this.orderRepository = orderRepository;
		this.customerClient = customerClient;
	}
	
	
	public Order CreateOrder (Order order) {
		if(customerClient.customerExists(order.getCustomerId())) {
		return orderRepository.save(order);
		}else {
			 throw new RuntimeException("Customer not found");
		}
	}
	
	public boolean customerExists(Long customerId) {
	    return customerClient.customerExists(customerId);
	}
	

}
