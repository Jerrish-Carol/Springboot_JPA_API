package springboot.jpa.api.response;

import java.util.List;

import lombok.Data;
import springboot.jpa.api.model.Employee;

@Data
public class CustomGetAllResponse {

	private List<Employee> content;
	

	public CustomGetAllResponse(List<Employee> employee) {
		this.content=employee;
	}
}
