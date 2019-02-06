package com.company.department.sapp.mocking.exception;

import java.sql.SQLException;

@SuppressWarnings("serial")
public class BOException extends Exception {
	
	public BOException(SQLException e) 
	{
		super(e);
	}
}
