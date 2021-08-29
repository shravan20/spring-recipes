package com.simulator.example.commons.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BadRequestException extends RuntimeException {

  private final String message;

  public BadRequestException(String message) {
    super(message);
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
