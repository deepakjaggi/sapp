package com.company.department.sapp.junit;

public class GreetingImpl implements Igreeting {

	@Override
	public String greet(String name) {
		if (name==null || name.length()==0)
		{
			throw new IllegalArgumentException();
		}
		return "Hello " + name;
	}
}
