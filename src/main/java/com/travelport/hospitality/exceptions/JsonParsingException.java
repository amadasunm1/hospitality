package com.travelport.hospitality.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
public class JsonParsingException extends RuntimeException {
	private static final long serialVersionUID = -6311820351235145850L;
	
	public JsonParsingException(String message) {
		super(message);
	}
	
}
