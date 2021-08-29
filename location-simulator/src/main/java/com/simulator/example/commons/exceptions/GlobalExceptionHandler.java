package com.simulator.example.commons.exceptions;

import com.simulator.example.commons.dto.ErrorResponse;
import com.simulator.example.commons.dto.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.simulator.example.commons.utils.constants.ERROR;

@ControllerAdvice
public class GlobalExceptionHandler {

  private static final org.slf4j.Logger log =
      org.slf4j.LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity handleBadRequestException(
      BadRequestException e, HttpServletResponse response) throws IOException {
    log.error(e.getMessage(), e);
    ErrorResponse errorResponse = new ErrorResponse();
    errorResponse.setCode(HttpStatus.BAD_REQUEST);
    errorResponse.setMessage(e.getMessage());
    return new ResponseEntity<>(new ResponseMessage(ERROR, errorResponse), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity handleNotFoundException(NotFoundException e, HttpServletResponse response)
      throws IOException {
    log.error(e.getMessage(), e);
    ErrorResponse errorResponse = new ErrorResponse();
    errorResponse.setCode(HttpStatus.NOT_FOUND);
    errorResponse.setMessage(e.getMessage());
    return new ResponseEntity<>(new ResponseMessage(ERROR, errorResponse), HttpStatus.NOT_FOUND);
  }


  @ExceptionHandler(InternalServerErrorException.class)
  public ResponseEntity handleInternalServerErrorException(
      InternalServerErrorException e, HttpServletResponse response) throws IOException {
    log.error(e.getMessage(), e);
    ErrorResponse errorResponse = new ErrorResponse();
    errorResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR);
    errorResponse.setMessage(e.getMessage());
    return new ResponseEntity<>(
        new ResponseMessage(ERROR, errorResponse), HttpStatus.INTERNAL_SERVER_ERROR);
  }


}
