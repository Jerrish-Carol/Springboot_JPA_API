package springboot.jpa.api.service;

import java.util.List;

import springboot.jpa.api.model.Employee;

public interface EmployeeService {  
	
	List<Employee> getEmployees(); // returns all the employee details
	
	Employee saveEmployee(Employee employee) ; //returns employee details that was saved
	
	Employee getSingleEmployee(Long ID); //returns employee details via ID
	
	void deleteEmployee(Long ID); // since it returns nothing
	
	Employee updateEmployee(Employee employee); // returns the updated employee value
	
	List<Employee> getEmployeeByName(String name);
	
	//List<Employee> getEmployeeByNameAndLocation(String name, String location);
	
	List<Employee> getEmployeeByKeyword(String name);

}
