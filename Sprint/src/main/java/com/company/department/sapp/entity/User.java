package com.company.department.sapp.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private Date birthDate;
	
	@OneToMany(mappedBy="user")
	private List<Posts> posts;	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public List<Posts> getPosts() {
		return posts;
	}
	public void setPosts(List<Posts> posts) {
		this.posts = posts;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
	public User(Integer id, String name, Date birthDate) {
			super();
			this.id = id;
			this.name = name;
			this.birthDate = birthDate;
		}
	
	public User() {
		
	}
	
}
