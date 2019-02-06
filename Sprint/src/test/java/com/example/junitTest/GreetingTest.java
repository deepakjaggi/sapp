package com.example.junitTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.company.department.sapp.junit.GreetingImpl;
import com.company.department.sapp.junit.Igreeting;

class GreetingTest {

	private Igreeting iGreeting;	
	
	@BeforeEach
	void runBeforeEach() {
		iGreeting = new GreetingImpl();
	}
	@Test
	void greetShouldReturnValidOutput() {
		System.out.println("greetShouldReturnValidOutput");
		String result = iGreeting.greet("Manoj");
		
		Assertions.assertNotNull(result);
		Assertions.assertEquals("Hello Manoj", result);
	}
	
	@Test
	public void greetShouldThrowException() {
		System.out.println("greetShouldThrowException");
		Assertions.assertThrows
			(IllegalArgumentException.class, ()->{
				iGreeting.greet(null);
		});		
	}
	
	@Test
	public void greetShouldCheckForBlankName() {
		System.out.println("greetShouldCheckForBlankName");
		Assertions.assertThrows
		(IllegalArgumentException.class, ()->{
			iGreeting.greet(null);
		});
		
	}
	
	
}
