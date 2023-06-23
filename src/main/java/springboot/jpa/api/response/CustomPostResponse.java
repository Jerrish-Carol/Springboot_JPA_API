package springboot.jpa.api.response;

import java.util.List;

import lombok.Data;
import springboot.jpa.api.model.Employee;

@Data
public class CustomPostResponse {
	
	private Employee employee;
	
	private long StatusCode;

	private String message;
	
	
	public CustomPostResponse(long StatusCode, String message, Employee employee ) {
		super();
		this.StatusCode = StatusCode;
		this.message = message;
		this.employee = employee;
	}



	

}
