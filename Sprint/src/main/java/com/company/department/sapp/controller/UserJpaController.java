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

import com.company.department.sapp.entity.Posts;
import com.company.department.sapp.entity.User;
import com.company.department.sapp.exception.UserNotfoundException;
import com.company.department.sapp.repos.PostsRepo;
import com.company.department.sapp.repos.UserRepo;

@RestController
public class UserJpaController {
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private PostsRepo postRepo;

	@GetMapping("/jpa/users")
	public List<User> retrieveUsers() {

		System.out.println("Size of Users is : " + userRepo.findAll().size());
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

	@GetMapping("/jpa/users/{id}/post")
	public List<Posts> getUserPosts(@PathVariable int id) {
		Optional<User> user = userRepo.findById(id);
		if (!user.isPresent())
			throw new UserNotfoundException("User is not found for Id " + id);
		return user.get().getPosts();
	}

	@PostMapping("/jpa/AddUserPost/{id}/post")
	public User createPostForUser(@PathVariable int id, @Valid @RequestBody Posts post) 
	{
		Optional<User> userOptional = userRepo.findById(id);

		if (!userOptional.isPresent())
			throw new UserNotfoundException("User is not found for Id " + id);

		User user = userOptional.get();
		post.setUser(user);
		postRepo.save(post);
		return user;
	}
}
