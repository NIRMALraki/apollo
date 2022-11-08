package com.employee.advice;

import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.employee.custom.exception.EmptyInputException;

@ControllerAdvice
public class MyControllerAdvice extends ResponseEntityExceptionHandler{

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException ex)
	{
		return new ResponseEntity<String>("no such value present in db,please give valid value",HttpStatus.NOT_FOUND);
	}
	
//	@ExceptionHandler(HttpMessageNotReadableException.class)
//	public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex)
//	{
//		return new ResponseEntity<String>("klnjknjk",HttpStatus.NOT_ACCEPTABLE);
//	}
	
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleNoSuchElementException(EmptyInputException ex)
	{
		return new ResponseEntity<String>(ex.getErroeMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return new ResponseEntity<Object>("invalid request method",HttpStatus.METHOD_NOT_ALLOWED);
	}

	
}
