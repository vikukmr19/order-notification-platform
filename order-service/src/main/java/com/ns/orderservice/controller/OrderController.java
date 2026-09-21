package com.ns.orderservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ns.orderservice.entity.Order;
import com.ns.orderservice.service.OrderService;

import jakarta.validation.Valid;


@RestController
public class OrderController {
	
	
private final OrderService orderService;


public OrderController(OrderService orderService) {
 
	this.orderService = orderService;
}


@PostMapping("/orders/")
public Order createOrder(@Valid @RequestBody Order order) {
	return orderService.CreateOrder(order);
}
	
}
