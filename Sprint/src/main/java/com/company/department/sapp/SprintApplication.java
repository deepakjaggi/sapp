package com.company.department.sapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class SprintApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprintApplication.class, args);
	}

}

