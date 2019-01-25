package com.company.department.sapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.department.sapp.entity.Posts;

@Repository
public interface PostsRepo extends JpaRepository<Posts, Integer> {
	
}
