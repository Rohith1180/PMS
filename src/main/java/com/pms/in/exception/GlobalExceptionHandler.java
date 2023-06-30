package com.pms.in.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException pnfe){
		
		ResponseEntity re=new ResponseEntity<String>(pnfe.getMessage(),HttpStatus.NOT_FOUND);
		return re;
	}
	
	
}
