package com.company.department.sapp.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.company.department.sapp.response.ExcpetionResponse;

@ControllerAdvice
@Controller
public class CustomizedExceptionhandler extends ResponseEntityExceptionHandler {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
		
		ExcpetionResponse excpetionResponse = new ExcpetionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));
		
		//return new ResponseEntity(excpetionResponse, HttpStatus.METHOD_NOT_ALLOWED);
		return new ResponseEntity(excpetionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
