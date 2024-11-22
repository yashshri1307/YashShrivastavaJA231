package com.hexaware.CricketTeamManagementSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(PlayerAlreadyExistsException.class)
    public ResponseEntity<String> handleException(PlayerAlreadyExistsException ex) {
  
  return new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
    }
	
	@ExceptionHandler(PlayerNotFoundException.class)
    public ResponseEntity<String> handleException(PlayerNotFoundException ex) {
  
  return new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
    }

}
