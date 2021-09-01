package com.example.employee.commons.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Bad request exception. @ResponseStatus the status code is applied to the HTTP response
 * when the handler method is invoked and overrides status information
 *
 * <p>@JsonIgnoreProperties is used to either suppress serialization of properties (during
 * serialization), or ignore processing of JSON properties read (during deserialization).
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BadRequestException extends RuntimeException {

  private final String message;

  /**
   * Instantiates a new Bad request exception.
   *
   * @param message the message
   */
  public BadRequestException(String message) {
    super(message);
    this.message = message;
  }

  /** @return message */
  @Override
  public String getMessage() {
    return message;
  }
}
