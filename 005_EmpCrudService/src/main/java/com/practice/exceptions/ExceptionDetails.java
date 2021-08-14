package com.practice.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ExceptionDetails {

	private HttpStatus status;
	private Date timeStamp;
	private String message;
	
	
	public ExceptionDetails(HttpStatus status, Date timeStamp, String message) {
		super();
		this.status = status;
		this.timeStamp = timeStamp;
		this.message = message;
	}


	public HttpStatus getStatus() {
		return status;
	}


	public void setStatus(HttpStatus status) {
		this.status = status;
	}


	public Date getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}

}
