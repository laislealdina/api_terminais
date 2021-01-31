package com.laisleal.desafiotecnico.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import com.laisleal.desafiotecnico.services.exceptions.ErrorHandled;
import com.laisleal.desafiotecnico.services.exceptions.ObjectNoFoundException;


//Classe para interceptar as exceções e por padrão tem que conter o métodos na forma padrão abaixo
@ControllerAdvice
public class ExceptionHandlerResource extends Throwable{
	private static final long serialVersionUID = 1L;

	@ExceptionHandler(ObjectNoFoundException.class)
	public ResponseEntity<ErrorHandled> ObjectNoFoundException(ObjectNoFoundException e, HttpServletRequest request) {
		ErrorHandled error = new ErrorHandled(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
}
