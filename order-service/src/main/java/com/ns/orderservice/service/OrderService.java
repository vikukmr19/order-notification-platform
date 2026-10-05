package com.ns.orderservice.service;

import org.springframework.stereotype.Service;
import com.ns.orderservice.config.RestClientConfig;
import com.ns.orderservice.entity.Order;
import com.ns.orderservice.exception.CustomerNotFoundException;
import com.ns.orderservice.repository.OrderRepository;


@Service
public class OrderService {

    private final RestClientConfig restClientConfig;

	private final OrderRepository orderRepository;
	private final CustomerClient customerClient;


	public OrderService(OrderRepository orderRepository, CustomerClient customerClient, RestClientConfig restClientConfig) {
		 
		this.orderRepository = orderRepository;
		this.customerClient = customerClient;
		this.restClientConfig = restClientConfig;
	}
	
	
	public Order CreateOrder (Order order) {
		if(customerClient.customerExists(order.getCustomerId())) {
		return orderRepository.save(order);
		}else {
			throw new CustomerNotFoundException(order.getCustomerId());
		}
	}
	
	public boolean customerExists(Long customerId) {
	    return customerClient.customerExists(customerId);
	}
	

}
