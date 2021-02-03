package com.laisleal.desafiotecnico.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

import com.laisleal.desafiotecnico.services.exceptions.ErrorHandled;

public class ValidationError extends ErrorHandled {
	private List<FieldMessage> errors = new ArrayList();
	
	public ValidationError(Integer status, String msg, Long timestamp) {
		super(status, msg, timestamp);
		// TODO Auto-generated constructor stub
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void setList(List<FieldMessage> errors) {
		this.errors = errors;
	}
	
	public void addError(String fieldName, String message) {
		errors.add(new FieldMessage(fieldName,message));
	}
	
		
	
}
