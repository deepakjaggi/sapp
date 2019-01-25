package com.company.department.sapp.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.department.sapp.entity.User;
import com.company.department.sapp.exception.UserNotfoundException;
import com.company.department.sapp.repos.UserRepo;

@RestController
public class UserJpaController {
	@Autowired
	private UserRepo userRepo;

	@GetMapping("/jpa/users")
	public List<User> retrieveUsers() {
		return userRepo.findAll();
	}

	@GetMapping("/jpa/users/{id}")
	public Optional<User> retrieveUser(@PathVariable int id) {
		Optional<User> user = userRepo.findById(id);
		if (!user.isPresent())
			throw new UserNotfoundException("User is not found for Id " + id);
		return user;
	}

	@PostMapping("/jpa/users")
	public User addUserWithResponse(@Valid @RequestBody User user) {
		User savedUser = userRepo.save(user);
		return savedUser;
	}

	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepo.deleteById(id);
	}

}
