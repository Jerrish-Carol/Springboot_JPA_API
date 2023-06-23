package springboot.jpa.api.response;

import java.util.List;

import lombok.Data;
import springboot.jpa.api.model.Address;
import springboot.jpa.api.model.Employee;

@Data
public class CustomSuccessResponse {

	//public static final String HttpStatus = null;

	
	private List<Employee> content;
	
	private Employee employee;
	
	private long StatusCode;

	private String message;
	
	
	/*public CustomSuccessResponse(long StatusCode, String message, List<Employee> content ) {
		super();
		this.StatusCode = StatusCode;
		this.message = message;
		this.content = content;
	}

*/

	public CustomSuccessResponse(long StatusCode, String message, Employee employee) {
		super();
		this.StatusCode = StatusCode;
		this.message = message;
		this.employee = employee;
	}



	



	



	
}
