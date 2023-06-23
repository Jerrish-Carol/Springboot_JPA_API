package springboot.jpa.api.service;

import java.util.List;

import springboot.jpa.api.model.Employee;
import springboot.jpa.api.response.CustomGetAllResponse;
import springboot.jpa.api.response.CustomGetResponse;
import springboot.jpa.api.response.CustomPostResponse;
import springboot.jpa.api.response.CustomSuccessResponse;

public interface EmployeeService {  
	
	CustomGetAllResponse getEmployees(); // returns all the employee details
	
	CustomPostResponse saveEmployee(Employee employee) ; //returns employee details that was saved
	
	CustomGetResponse getSingleEmployee(Long ID); //returns employee details via ID
	
	void deleteEmployee(Long ID); // since it returns nothing
	
	CustomPostResponse updateEmployee(Employee employee); // returns the updated employee value
	
	//CustomSuccessResponse getEmployeeByName(String name);
	
	//List<Employee> getEmployeeByNameAndLocation(String name, String location);
	
	//CustomSuccessResponse getEmployeeByKeyword(String name);

}
