package springboot.jpa.api.response;

import lombok.Data;
import springboot.jpa.api.model.Employee;

@Data
public class CustomGetResponse {

	private Employee employee;

	public CustomGetResponse(Employee employee) {
		this.employee = employee;
	}
}
