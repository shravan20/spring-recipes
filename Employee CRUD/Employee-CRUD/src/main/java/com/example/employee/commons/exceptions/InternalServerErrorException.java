package com.example.employee.commons.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Internal server error exception.
 *
 * <p>@JsonIgnoreProperties is used to either suppress serialization of properties (during
 * serialization), or ignore processing of JSON properties read (during
 * deserialization). @ResponseStatus the status code is applied to the HTTP response when the
 * handler method is invoked and overrides status information
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerErrorException extends RuntimeException {

	private final String message;

	/**
	 * Instantiates a new Internal server error exception.
	 *
	 * @param message the message
	 */
	public InternalServerErrorException(String message) {
		super(message);
		this.message = message;
	}

	/**
	 * get message
	 *
	 * @return message
	 */
	public String getMessage() {
		return this.message;
	}
}
