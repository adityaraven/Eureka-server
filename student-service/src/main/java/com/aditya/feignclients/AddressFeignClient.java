package com.aditya.feignclients;

import org.aspectj.weaver.WeakClassLoaderReference;
import org.hibernate.tool.hbm2ddl.SingleLineSqlCommandExtractor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.aditya.response.AddressResponse;

//@FeignClient(url="${address.service.url}",
//				value="address-feign-client",
//				path ="/api/address")


//since after eureka we dont have to manually enter address just the servicename is enough
//@FeignClient(value="address-service",path="/api/address")


//now we want to use api-gateway instead of directly refering to the service 
@FeignClient(value="api-gateway")
public interface AddressFeignClient {

//	 Since We are using api-gateway so we need to write service name while requesting
//	@GetMapping("/getById/{id}")
	
	@GetMapping("address-service/api/address/getById/{id}")
	public AddressResponse getById(@PathVariable long id);
		
	
}
