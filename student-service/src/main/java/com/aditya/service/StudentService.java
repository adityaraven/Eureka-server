package com.aditya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.aditya.entity.Student;
import com.aditya.feignclients.AddressFeignClient;
import com.aditya.repository.StudentRepository;
import com.aditya.request.CreateStudentRequest;
import com.aditya.response.StudentResponse;

@Service
public class StudentService {
	
	

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	WebClient webClient;
	
	@Autowired
	AddressFeignClient addressFeignClient;
	
	@Autowired
	CommonService commonService;

	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {

		Student student = new Student();
		student.setFirstName(createStudentRequest.getFirstName());
		student.setLastName(createStudentRequest.getLastName());
		student.setEmail(createStudentRequest.getEmail());
		student.setAddressId(createStudentRequest.getAddressId());
		
		student = studentRepository.save(student);
		
		StudentResponse studentResponse = new StudentResponse(student);
		
//		Setting the Address by Fetching address details with webClient
//		studentResponse.setAddressResponse(getAddressById(student.getAddressId()));
		
		
//		Setting the Address by Fetching address details with FeignClient client
//		studentResponse.setAddressResponse(addressFeignClient.getById(student.getAddressId()));
		

		//for using circuit breaker
		studentResponse.setAddressResponse(commonService.getAddressById(student.getAddressId()));
		return new StudentResponse(student);
	}
	
	public StudentResponse getById(long id) {
		Student student = studentRepository.findById(id).get();
		StudentResponse studentResponse = new StudentResponse(student);
		
//		Setting the Address by Fetching address details with webClient
//		studentResponse.setAddressResponse(getAddressById(student.getAddressId()));
		
//		Setting the Address by Fetching address details with FeignClient client
//		studentResponse.setAddressResponse(addressFeignClient.getById(student.getAddressId()));
		
		//for using circuit breaker
		studentResponse.setAddressResponse(commonService.getAddressById(student.getAddressId()));
		return studentResponse;
	}
	
//	to call the address service from student service and that why we can get the response from address using webClient
//	public AddressResponse getAddressById(long addressId) {
//		Mono<AddressResponse> addressResponse =
//		webClient.get().uri("/getById/" + addressId)
//		.retrieve().bodyToMono(AddressResponse.class);
//		
//		return addressResponse.block();
//	}
	
	
	
	
	//we are commenting it because we cannot call the method in Reselience4j because reselience4j uses AOP  and AOP does not allow method call in the same class so we need to create a seperate class for Circuit Breaker here CommonSerive.java
//	//for circuit breaker resilience4j
//	@CircuitBreaker(name= "addressService", fallbackMethod = "fallBackGetAddresById") //name=instance name of service is circuit is closed, if response is not coming it will go to fallbackmethod i.e., fallBackGetAddresById
//	public AddressResponse getAddressById(long addressId) {
//		
//		AddressResponse addressResponse = addressFeignClient.getById(addressId);
//		
//		
//				return addressResponse;
//	}
//	
//	//method signature should be same as what we used at circuit breaker above just the name of method is changed
//	//if response if not coming we  use fallback method (dummy response)
//	public AddressResponse fallBackGetAddressById(long addressId) {
//		
//		return new AddressResponse();
//	}
}
