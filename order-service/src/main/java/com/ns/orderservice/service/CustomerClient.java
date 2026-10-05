package com.ns.orderservice.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.ResourceAccessException;
import com.ns.orderservice.exception.CustomerServiceUnavailableException;

@Component
public class CustomerClient {
	private final RestClient restClient;

	public CustomerClient(RestClient restClient) {
		 
		this.restClient = restClient;
	}
	
	
//	public boolean customerExists(Long customerId) {
//
//       
//           return restClient.get()
//                    .uri("http://localhost:8081/customers/{id}", customerId)
//                    .exchange((request,response) ->{
//                    	if(response.getStatusCode().is2xxSuccessful()) {
//                    		return true;
//                    	}
//                    	if (response.getStatusCode().value() == 404) {
//                            return false;
//                        }
//                    	
//                    	 throw new RuntimeException(
//                                 "Customer Service returned status: "
//                                 + response.getStatusCode()
//                         );
//                    });
//
//            
//
//        
//    }
	
	public boolean customerExists(Long customerId) {

	    try {

	        return restClient.get()
	                .uri("http://localhost:8081/customers/{id}", customerId)
	                .exchange((request, response) -> {

	                    if (response.getStatusCode().is2xxSuccessful()) {
	                        return true;
	                    }

	                    if (response.getStatusCode().value() == 404) {
	                        return false;
	                    }

	                    throw new RuntimeException(
	                            "Customer Service returned status: "
	                                    + response.getStatusCode()
	                    );
	                });

	    } catch (ResourceAccessException e) {

	        throw new CustomerServiceUnavailableException();
	    }
	}
	
	

}
