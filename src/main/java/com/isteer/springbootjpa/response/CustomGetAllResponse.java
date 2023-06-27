package com.isteer.springbootjpa.response;

import java.util.List;

import lombok.Data;
import com.isteer.springbootjpa.model.Employee;

@Data
public class CustomGetAllResponse {

	private List<Employee> content;

	public CustomGetAllResponse(List<Employee> employee) {
		this.content = employee;
	}
}
