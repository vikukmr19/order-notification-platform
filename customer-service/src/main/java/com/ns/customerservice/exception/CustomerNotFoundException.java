package com.ns.customerservice.exception;

public class CustomerNotFoundException extends RuntimeException {

		public CustomerNotFoundException(Long Id)   {
			super("Customer Not Found with id :"+Id);
		}
	
	
	

}
