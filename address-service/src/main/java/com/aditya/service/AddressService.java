package com.aditya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aditya.entity.Address;
import com.aditya.repository.AddressRepository;
import com.aditya.request.CreateAddressRequest;
import com.aditya.response.AddressResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Service
public class AddressService {
	
	Logger logger = LogManager.getLogger(AddressService.class);
	
	@Autowired
	AddressRepository addressRepository;
	
	public AddressResponse createAddress(CreateAddressRequest createAddressRequest) {
		Address address= new Address();
		address.setStreet(createAddressRequest.getStreet());
		address.setCity(createAddressRequest.getCity());
		
		addressRepository.save(address);
		
		return new AddressResponse(address);
	}

	public AddressResponse getById(long id) {
		logger.info("Inside getById " + id);
		
		Address address=addressRepository.findById(id).get();
		
		return new AddressResponse(address);
	}
}
