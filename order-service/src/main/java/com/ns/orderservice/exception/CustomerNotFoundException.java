package com.ns.orderservice.exception;
import org.springframework.web.bind.annotation.RestControllerAdvice;

public class CustomerNotFoundException extends RuntimeException {

		public CustomerNotFoundException(Long Id)   {
			super("Customer Not Found with id :"+Id);
		}
	
	
	

}
