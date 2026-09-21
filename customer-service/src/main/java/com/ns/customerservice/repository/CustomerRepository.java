package com.ns.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ns.customerservice.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
