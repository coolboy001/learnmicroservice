package com.anshul.learnmicroservices;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidExceptione(MethodArgumentNotValidException ex){
		Map<String, String> res = new HashMap<String, String>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName=((FieldError)error).getField();
			String message = error.getDefaultMessage();
			res.put(fieldName, message);
			
		});
		return new ResponseEntity<Map<String, String>>(res, HttpStatus.BAD_REQUEST); 
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity handleConstraintViolationException(ConstraintViolationException ex){
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
	}
	
	
}
