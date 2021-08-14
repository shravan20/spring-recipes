package com.practice.exceptions;

public class CannotUpdateException extends RuntimeException {

	public CannotUpdateException(String message) {
		super(message);
	}
}
