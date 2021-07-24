package com.br.calcme.restcontrollers.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.br.calcme.services.exceptions.UserException;
@ControllerAdvice
public class ResourceExceptionsHandler {

	@ExceptionHandler(UserException.class)
	public ResponseEntity<StandartError> objectNotFound(UserException e,
			HttpServletRequest request) {
		StandartError err = new StandartError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
}
