package com.code.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.code.entities.ErrorRespose;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<?> handleProductNotFoundException(ProductNotFoundException e) {
		ErrorRespose productNotFound = new ErrorRespose(LocalDateTime.now(), e.getMessage(), "Product Not Found");
		return new ResponseEntity<>(productNotFound, HttpStatus.NOT_FOUND);
	}

}
