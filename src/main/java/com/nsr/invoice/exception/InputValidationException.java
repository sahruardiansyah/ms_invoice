package com.nsr.invoice.exception;

import org.springframework.core.MethodParameter;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class InputValidationException extends MethodArgumentNotValidException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InputValidationException(MethodParameter parameter, BindingResult bindingResult) {
		super(parameter, bindingResult);
		// TODO Auto-generated constructor stub
	}



}
