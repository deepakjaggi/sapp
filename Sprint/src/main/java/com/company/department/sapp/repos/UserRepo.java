package com.company.department.sapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.department.sapp.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	
}
