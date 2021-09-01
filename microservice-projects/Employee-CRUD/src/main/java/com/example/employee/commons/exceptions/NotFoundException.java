package com.example.employee.commons.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type not found exception
 *
 * <p>@JsonIgnoreProperties is used to either suppress serialization of properties (during
 * serialization), or ignore processing of JSON properties read (during deserialization).
 *
 * <p>@ResponseStatus the status code is applied to the HTTP response when the handler method is
 * invoked and overrides status information
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

	private String message;
}
