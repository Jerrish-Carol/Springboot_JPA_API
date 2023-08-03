package com.isteer.springbootjpa.response;

import lombok.Data;
import com.isteer.springbootjpa.model.Employee;

@Data
public class CustomPostResponse {

	private Employee employee;

	private long statusCode;

	private String message;

	public CustomPostResponse(long statusCode, String message, Employee employee) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.employee = employee;
	}

}
