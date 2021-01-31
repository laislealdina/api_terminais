package com.laisleal.desafiotecnico.services.exceptions;

public class ConstraintViolatedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ConstraintViolatedException(String msg) {
		super(msg);
	}
	
	public ConstraintViolatedException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
