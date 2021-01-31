package com.laisleal.desafiotecnico.services.exceptions;

public class ErrorHandled {
	
	private Integer status;
	private String message;
	private Long moment;
	
	public ErrorHandled(Integer status, String message, Long moment) {
		super();
		this.status = status;
		this.message = message;
		this.moment = moment;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getMoment() {
		return moment;
	}

	public void setMoment(Long moment) {
		this.moment = moment;
	}
	
	

}
