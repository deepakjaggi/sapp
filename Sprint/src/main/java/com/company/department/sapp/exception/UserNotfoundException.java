package com.company.department.sapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)

public class UserNotfoundException extends RuntimeException {

	public UserNotfoundException(String message) {
		super(message);	
	}

}
