package com.cignex.microservices.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ExceptionController extends ResponseEntityExceptionHandler{

	@ExceptionHandler(ExchangeValueNotFoundException.class)
	protected ResponseEntity<ExceptionModel> handleExceptionInternal(Exception ex,WebRequest request) {
		ExceptionModel exceptionModel = new ExceptionModel(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<ExceptionModel>(exceptionModel, HttpStatus.NOT_FOUND);
	}



}
