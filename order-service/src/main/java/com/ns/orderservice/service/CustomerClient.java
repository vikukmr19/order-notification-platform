package com.ns.orderservice.service;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class CustomerClient {
	private final RestClient restClient;

	public CustomerClient(RestClient restClient) {
		 
		this.restClient = restClient;
	}
	
	
	public boolean customerExists(Long customerId) {

        try {
            restClient.get()
                    .uri("http://localhost:8081/customers/{id}", customerId)
                    .retrieve()
                    .toBodilessEntity();

            return true;

        } catch (Exception e) {
            return false;
        }
    }
	
	

}
