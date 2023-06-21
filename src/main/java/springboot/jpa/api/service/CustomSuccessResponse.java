package springboot.jpa.api.service;

import java.util.List;
import java.util.Optional;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import springboot.jpa.api.exception.CustomResponse;
import springboot.jpa.api.model.Employee;

@Data
@RequiredArgsConstructor
public class CustomSuccessResponse {
	
		private String StatusCode;

		private String message;
		
		private Optional<Employee> employee;

		
		
		public CustomSuccessResponse(String StatusCode, String message, Optional<Employee> employee) {
			super();
			this.StatusCode = StatusCode;
			this.message = message;
			this.employee = employee;
		}



		
}
