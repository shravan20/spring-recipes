package com.practice.controllers.advices;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.practice.exceptions.CannotAddException;
import com.practice.exceptions.ExceptionDetails;
import com.practice.exceptions.ResourceAlreadyExistsException;
import com.practice.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class EmployeeExceptionsAdvice {

	@ExceptionHandler(value= {ResourceNotFoundException.class})
	public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex){
		ExceptionDetails errorDetails = new ExceptionDetails(HttpStatus.NOT_FOUND, new Date(), ex.getMessage());
		return new ResponseEntity<Object>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value= {ResourceAlreadyExistsException.class})
	public ResponseEntity<Object> handleResourceAlreadyExistsException(ResourceAlreadyExistsException ex){
		ExceptionDetails errorDetails = new ExceptionDetails(HttpStatus.METHOD_NOT_ALLOWED, new Date(), ex.getMessage());
		return new ResponseEntity<Object>(errorDetails, HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	@ExceptionHandler(value= {CannotAddException.class})
	public ResponseEntity<Object> handleCannotAddException(CannotAddException ex){
		ExceptionDetails errorDetails = new ExceptionDetails(HttpStatus.INTERNAL_SERVER_ERROR, new Date(), ex.getMessage());
		return new ResponseEntity<Object>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
