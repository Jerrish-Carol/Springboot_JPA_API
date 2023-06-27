package com.isteer.springbootjpa.response;

import lombok.Data;
import com.isteer.springbootjpa.model.Employee;

@Data
public class CustomPostResponse {

	private Employee employee;

	private long StatusCode;

	private String message;

	public CustomPostResponse(long StatusCode, String message, Employee employee) {
		super();
		this.StatusCode = StatusCode;
		this.message = message;
		this.employee = employee;
	}

}
