package com.aditya.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aditya.feignclients.AddressFeignClient;
import com.aditya.response.AddressResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CommonService {

	Logger Logger= LoggerFactory.getLogger(CommonService.class);
	
	long count =1;
	
	@Autowired
	AddressFeignClient addressFeignClient;
	
	//for circuit breaker resilience4j
	@CircuitBreaker(name= "addressService", fallbackMethod = "fallBackGetAddresById") //name=instance name of service is circuit is closed, if response is not coming it will go to fallbackmethod i.e., fallBackGetAddresById
	public AddressResponse getAddressById(long addressId) {
		
		Logger.info("count = "  + count);
		count++;
		AddressResponse addressResponse = addressFeignClient.getById(addressId);
		
		
				return addressResponse;
	}
	
	//method signature should be same as what we used at circuit breaker above just the name of method is changed
	//if response if not coming we  use fallback method (dummy response)
	public AddressResponse fallBackGetAddressById(long addressId, Throwable th) {
		Logger.error("Error = " + th);
		return new AddressResponse();
	}
}
