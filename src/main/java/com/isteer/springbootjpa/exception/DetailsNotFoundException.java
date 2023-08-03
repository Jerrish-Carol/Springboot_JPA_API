package com.isteer.springbootjpa.exception;

import java.util.List;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class DetailsNotFoundException extends RuntimeException {

	private long httpStatus;
	private String message;
	private List<String> exception;

	public DetailsNotFoundException(long httpStatus, String message, List<String> exception) {
		super();
		this.httpStatus = httpStatus;
		this.message = message;
		this.exception = exception;
	}

}
