package com.company.department.sapp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.company.department.sapp.entity.User;

@Component
public class UserDaoService {
	public static int usersCount = 3;

	private static List<User> listOfUsers = new ArrayList<>();

	// Static block always executes once, at the time of loading the class
	static {
		listOfUsers.add(new User(101, "Andrew", new Date()));
		listOfUsers.add(new User(102, "Peter", new Date()));
		listOfUsers.add(new User(101, "Ricky", new Date()));
	}

	// Below method will return the list of all the users
	public List<User> findAll() {
		return listOfUsers;
	}

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++usersCount);
		}
		listOfUsers.add(user);
		return user;
	}

	public User findOne(int id) {
		for (User user : listOfUsers) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
}
