package com.example.employee.commons.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @ResponseStatus Annotation can be used to either suppress serialization of
 * properties (during serialization), or ignore processing of
 * JSON properties read (during deserialization).
 * The type Unauthorized exception.
 * <p>Exception Class for throwing UnauthorizeException with custom error message
 * Annotated with * {@link ResponseStatus @ResponseStatus which marks
 * this exception class with the status 401
 *
 * </p>**
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnAuthorizedException extends RuntimeException {

	/**
	 * Instantiates a new Unauthorized exception.
	 *
	 * @param message the message
	 */
	public UnAuthorizedException(String message) {
		super(message);
	}
}
