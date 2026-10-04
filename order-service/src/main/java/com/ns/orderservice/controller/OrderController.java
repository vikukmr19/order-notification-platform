package com.ns.orderservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ns.orderservice.entity.Order;
import com.ns.orderservice.service.CustomerClient;
import com.ns.orderservice.service.OrderService;
 

import jakarta.validation.Valid;


@RestController
public class OrderController {
	
	
private final OrderService orderService;
private final CustomerClient customerClient;


public OrderController(OrderService orderService, CustomerClient customerClient) {
 
	this.orderService = orderService;
	this.customerClient = customerClient;
}


@PostMapping("/orders/")
public Order createOrder(@Valid @RequestBody Order order) {
	return orderService.CreateOrder(order);
}

@GetMapping("/orders/check-customer/{customerId}")
public boolean checkCustomer(@PathVariable Long customerId) {
    return orderService.customerExists(customerId);
}
 
	
}
