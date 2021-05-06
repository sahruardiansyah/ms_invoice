package com.nsr.invoice.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{

	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> handleStudentNotFoundException(ResourceNotFoundException resourceNotFoundException) {
		return buildResponseEntity(
				new ApiError(HttpStatus.NOT_FOUND, resourceNotFoundException.getMessage(), resourceNotFoundException));
	}

	@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<>();
        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }
        ApiError error = new ApiError(HttpStatus.BAD_REQUEST,"Validation failed", details, ex);

        return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
    }
	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseEntity<Object> handleConstraintViolation(
	  ConstraintViolationException ex, WebRequest request) {
	    List<String> errors = new ArrayList<String>();
	    for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
	        errors.add(
//	        		violation.getRootBeanClass().getName() + " " + 
//	          violation.getPropertyPath() + ": " + 
	        		violation.getMessage());
	    }
	    ApiError apiError = 
	      new ApiError(HttpStatus.BAD_REQUEST,"Validation Failed!",errors);
	    return new ResponseEntity<Object>(
	      apiError, new HttpHeaders(), apiError.getStatus());
	}
}
