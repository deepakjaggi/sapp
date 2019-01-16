package com.company.department.sapp.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.company.department.sapp.entity.User;
import com.company.department.sapp.exception.UserNotfoundException;
import com.company.department.sapp.service.UserDaoService;

@RestController
@ComponentScan
public class UserController {

	@Autowired
	private UserDaoService userDaoService;

	// Below method will return the list of all the users
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return userDaoService.findAll();
	}
	
	//Below method will add the specific User to the existing user's list
	@PostMapping("/addUsers")
	public User addUser(@RequestBody User user){
		return userDaoService.save(user);
	}
	
	@PostMapping("/UsersWithURI")
	public ResponseEntity<Object> addUserWithResponse(@RequestBody User user){
		User savedUser= userDaoService.save(user);
		 
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();			
		}
	
		@GetMapping("/UsersWithURI/{id}")
		public User retrieveUser(@PathVariable int id){
			User user = userDaoService.findOne(id);		
			if(user==null)
				throw new UserNotfoundException("User is not found for Id "+id);
			return user;
		}
}
