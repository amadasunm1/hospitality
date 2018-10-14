package com.travelport.hospitality.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class StateNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -2977894784181525963L;

	public StateNotFoundException(String message) {
		super(message);
	}
}
