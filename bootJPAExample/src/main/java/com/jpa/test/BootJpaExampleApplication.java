package com.jpa.test;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepo;
import com.jpa.test.entities.User;
import com.sun.net.httpserver.Authenticator.Result;

@SpringBootApplication
public class BootJpaExampleApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext= SpringApplication.run(BootJpaExampleApplication.class, args);
		
		UserRepo userRepo= applicationContext.getBean(UserRepo.class);
		
		//create object of user
//		User user1 =new User();
//		user1.setName("Aditya");
//		user1.setCity("Hazaribagh");
//		user1.setStatus("I am java programmer");
////		
//		User user2 =new User();
//		user2.setName("Adi");
//		user2.setCity("Haz");
//		user2.setStatus("I am python programmer");
//		
//
//		User user3 =new User();
//		user3.setName("Rohit");
//		user3.setCity("Ranchi");
//		user3.setStatus("I am C++ programmer");
		
		//saving single user
//		User resultUser= userRepo.save(user1);
//		System.out.print("saved user" + resultUser);
		
		
		//saving Multiple user
//		List<User> users= List.of(user1,user2,user3);
//		Iterable<User> result= userRepo.saveAll(users);
//		
//		result.forEach(user->{
//			System.out.println(user);
//		});
		
		

//		System.out.print("done");
		
		
		
		//update  the user of id 11
//		Optional<User> optional = userRepo.findById(11);

//		System.out.print(optional.get());
		
//		User user= optional.get();
//		user.setName("Shashi");
//		User result =userRepo.save(user);
//		System.out.print(result);
		
		
		
		//findAll
//		Iterable<User> itr = userRepo.findAll();
//		
//		itr.forEach(user->{
//			System.out.println(user);
//		});
		
		//Delete the user element
//		userRepo.deleteById(10);
//		System.out.print("deleted");
		
		
		//delete all users
//		Iterable<User> itrIterable =userRepo.findAll();
//		
//		itrIterable.forEach(user->{
//			System.out.println(user);
//		});
//		
//		userRepo.deleteAll(itrIterable);
		
		
		//custom findByNameAndCity
//		List<User> users=userRepo.findByNameAndCity("Aditya", "Hazaribagh");
		
		
		//Custom findByNameStartingWith
//		List<User> users=userRepo.findByNameStartingWith("A");
//		users.forEach(user->{
//			System.out.println(user);
//		});
		
		
		
		//@query
//		List<User> users=userRepo.getAllUsers();
//		users.forEach(user->{
//			System.out.println(user);
//		});
		
		// Query with param
		List<User> userByName= userRepo.getUserByName("Aditya");
		userByName.forEach(e->{
			System.out.println(e);
		});
		
		
	}

}
