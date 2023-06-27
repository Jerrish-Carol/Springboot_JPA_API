package com.isteer.springbootjpa.response;

import lombok.Data;
import com.isteer.springbootjpa.model.Employee;

@Data
public class CustomGetResponse {

	private Employee employee;

	public CustomGetResponse(Employee employee) {
		this.employee = employee;
	}
}
