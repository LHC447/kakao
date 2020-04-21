package com.kakao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BindException.class)
	protected ResponseEntity<ErrorMessage> handleBindException(BindException e) {
		ErrorMessage errorMessage = new ErrorMessage();

		errorMessage.setStatus(HttpStatus.BAD_REQUEST.toString());
		errorMessage.setMessage("invalid email");

		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);

	}


	
	@ExceptionHandler(EmailAlreadyUsedException.class)
	protected ResponseEntity<ErrorMessage> handleEmailAlreadyUsedException(EmailAlreadyUsedException e) {
		ErrorMessage errorMessage = new ErrorMessage();

		errorMessage.setStatus(HttpStatus.BAD_REQUEST.toString());
		errorMessage.setMessage(e.getMessage());

		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}

}
