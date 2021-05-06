package com.nsr.invoice.exception;

import javax.persistence.EntityNotFoundException;

public class ResourceNotFoundException extends EntityNotFoundException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3187986102196170224L;
	
	public ResourceNotFoundException(String message) {
		super(message);
	}

}
