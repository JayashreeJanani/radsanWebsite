package com.radsan.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex)
	{
		ErrorResponse error = new ErrorResponse(
				HttpStatus.NOT_FOUND.value(),ex.getMessage()
				);
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(error);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationExceptions(
	        MethodArgumentNotValidException ex) {

	    Map<String, String> errors = new HashMap<>();

	    ex.getBindingResult()
	      .getFieldErrors()
	      .forEach(error ->
	          errors.put(
	              error.getField(),
	              error.getDefaultMessage()
	          )
	      );

	    return ResponseEntity
	            .status(HttpStatus.BAD_REQUEST)
	            .body(errors);
	}
	
	@ExceptionHandler(ResourceAlreadyExistsException.class)
	public ResponseEntity<ErrorResponse> handleResourceAlreadyExists(
	        ResourceAlreadyExistsException ex) {

	    ErrorResponse error = new ErrorResponse(
	            HttpStatus.CONFLICT.value(),
	            ex.getMessage()
	    );

	    return ResponseEntity
	            .status(HttpStatus.CONFLICT)
	            .body(error);
	}
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ErrorResponse> handleBadRequest(
	        BadRequestException ex) {

	    ErrorResponse error = new ErrorResponse(
	            HttpStatus.BAD_REQUEST.value(),
	            ex.getMessage()
	    );

	    return ResponseEntity
	            .status(HttpStatus.BAD_REQUEST)
	            .body(error);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGenericException(
	        Exception ex) {

	    ErrorResponse error = new ErrorResponse(
	            HttpStatus.INTERNAL_SERVER_ERROR.value(),
	            "An unexpected error occurred"
	    );

	    return ResponseEntity
	            .status(HttpStatus.INTERNAL_SERVER_ERROR)
	            .body(error);
	}

}
