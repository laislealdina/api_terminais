package com.laisleal.desafiotecnico.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.laisleal.desafiotecnico.services.exceptions.ConstraintViolatedException;
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
	
	@ExceptionHandler(ConstraintViolatedException.class)
	public ResponseEntity<ErrorHandled> ConstraintViolatedException(ConstraintViolatedException e, HttpServletRequest request) {
		ErrorHandled error = new ErrorHandled(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ErrorHandled> HttpMessageNotReadableException(HttpMessageNotReadableException e, HttpServletRequest request) {
		ErrorHandled error = new ErrorHandled(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
	
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public ResponseEntity<ErrorHandled> HttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e, HttpServletRequest request) {
		ErrorHandled error = new ErrorHandled(HttpStatus.BAD_REQUEST.value(), "O Endpoint não aceita como entrada esse formato de dados.", System.currentTimeMillis());
	
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ErrorHandled> MethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e, HttpServletRequest request) {
		ErrorHandled error = new ErrorHandled(HttpStatus.BAD_REQUEST.value(), "Valor para chave Logic é muito grande.", System.currentTimeMillis());
	
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> Validation(MethodArgumentNotValidException e, HttpServletRequest request) {
		ValidationError error = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Erro de Validação.", System.currentTimeMillis());
		
		for (FieldError x : e.getBindingResult().getFieldErrors()) {
			error.addError(x.getField(), x.getDefaultMessage());
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	
	
}
