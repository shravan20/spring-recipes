package com.example.employee.commons.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.example.employee.commons.utils.Constants.ERROR;

@Slf4j(topic = "GlobalErrorHandler")
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionAdvice extends ResponseEntityExceptionHandler {


	/**
	 * @param e
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ExceptionHandler(value = BadRequestException.class)
	public ResponseEntity handleBadRequestException(
		BadRequestException e, HttpServletResponse response) throws IOException {
		log.error(e.getMessage(), e);
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setCode(HttpStatus.BAD_REQUEST);
		errorResponse.setMessage(e.getMessage());
		return new ResponseEntity<>(new ResponseMessage(ERROR, errorResponse), HttpStatus.BAD_REQUEST);
	}

	/**
	 * @param e
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ExceptionHandler(value = NotFoundException.class)
	public ResponseEntity handleNotFoundException(NotFoundException e, HttpServletResponse response)
		throws IOException {
		log.error(e.getMessage(), e);
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setCode(HttpStatus.NOT_FOUND);
		errorResponse.setMessage(e.getMessage());
		return new ResponseEntity<>(new ResponseMessage(ERROR, errorResponse), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = PersistenceException.class)
	public ResponseEntity handlePersistenceException(
		PersistenceException e, HttpServletResponse response) throws IOException {
		log.error(e.getMessage(), e);
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR);
		errorResponse.setMessage(e.getMessage());
		return new ResponseEntity<>(
			new ResponseMessage(ERROR, errorResponse), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * @param e
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ExceptionHandler(value = AlreadyExistsException.class)
	public ResponseEntity handleReviewExistsException(
		AlreadyExistsException e, HttpServletResponse response) throws IOException {
		log.error(e.getMessage(), e);
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setCode(HttpStatus.CONFLICT);
		errorResponse.setMessage(e.getMessage());
		return new ResponseEntity<>(new ResponseMessage(ERROR, errorResponse), HttpStatus.CONFLICT);
	}

	/**
	 * @param e
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ExceptionHandler(value = InternalServerErrorException.class)
	public ResponseEntity handleInternalServerErrorException(
		InternalServerErrorException e, HttpServletResponse response) throws IOException {
		log.error(e.getMessage(), e);
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR);
		errorResponse.setMessage(e.getMessage());
		return new ResponseEntity<>(
			new ResponseMessage(ERROR, errorResponse), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * @param e
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ExceptionHandler(value = UnAuthorizedException.class)
	public ResponseEntity handleInternalUnauthorizedException(
		UnAuthorizedException e, HttpServletResponse response) throws IOException {
		log.error(e.getMessage(), e);
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setCode(HttpStatus.UNAUTHORIZED);
		errorResponse.setMessage(e.getMessage());
		return new ResponseEntity<>(new ResponseMessage(ERROR, errorResponse), HttpStatus.UNAUTHORIZED);
	}

	/**
	 * @param e
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ExceptionHandler(value = UnProcessableEntitiesException.class)
	public ResponseEntity handleUnProcessableEntitiesException(
		UnProcessableEntitiesException e, HttpServletResponse response) throws IOException {
		log.error(e.getMessage(), e);
		return new ResponseEntity<>(
			new ValidationErrorResponse(
				HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase(), e.getErrors()),
			HttpStatus.UNPROCESSABLE_ENTITY);
	}

	/**
	 * A method to handle field validation errors.
	 *
	 * @param ex
	 * @param headers
	 * @param status
	 * @param request
	 * @return response entity with custom error message
	 */
	@Override
	@SuppressWarnings("all")
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
		MethodArgumentNotValidException ex,
		HttpHeaders headers,
		HttpStatus status,
		WebRequest request) {
		Map<String, Object> hashMap = new HashMap<>();
		Map<String, String> errors = new LinkedHashMap<>();
		for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
			errors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		hashMap.put("errors", errors);
		return new ResponseEntity<>(hashMap, headers, status);
	}

}
