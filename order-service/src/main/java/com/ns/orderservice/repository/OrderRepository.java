package com.ns.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ns.orderservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
