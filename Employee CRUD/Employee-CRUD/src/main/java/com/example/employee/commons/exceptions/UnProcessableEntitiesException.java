package com.example.employee.commons.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/**
 * The type UnProcessableEntity Exception.
 * <p>Exception Class for throwing UnprocessableEntitiesException with custom error message
 * Annotated with {@link ResponseStatus @ResponseStatus which marks
 * this exception class with the status 422
 * </p>**
 * <p>
 *@JsonIgnoreProperties is used to either suppress serialization of properties (during
 * serialization), or ignore processing of JSON properties read (during deserialization). </p>
 * <p>
 * @ResponseStatus the status code is applied to the HTTP response when the handler
 * method is invoked and overrides status information
 * </p>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class UnProcessableEntitiesException extends RuntimeException {

  private List<com.timhortons.commons.exceptions.ValidationError> errors;
}
