package com.employee.globalexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.employee.exception.LessSalaryException;

@RestControllerAdvice
public class GlobalException {
	@ExceptionHandler(LessSalaryException.class)
	public ResponseEntity<Object> salaryHandler() {
		return new ResponseEntity<>("Less slary",HttpStatus.BAD_REQUEST);
	}
}
