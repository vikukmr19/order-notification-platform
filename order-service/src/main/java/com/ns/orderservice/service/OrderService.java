package com.ns.orderservice.service;

import org.springframework.stereotype.Service;
import com.ns.orderservice.entity.Order;

import com.ns.orderservice.repository.OrderRepository;

 
@Service
public class OrderService {

	private final OrderRepository orderRepository;

	public OrderService(OrderRepository orderRepository) {
		 
		this.orderRepository = orderRepository;
	}
	
	
	public Order CreateOrder (Order order) {
		return orderRepository.save(order);
	}
	

}
