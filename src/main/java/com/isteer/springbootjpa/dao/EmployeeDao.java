package com.isteer.springbootjpa.dao;

import com.isteer.springbootjpa.model.Employee;
import com.isteer.springbootjpa.response.CustomGetAllResponse;
import com.isteer.springbootjpa.response.CustomGetResponse;
import com.isteer.springbootjpa.response.CustomPostResponse;

public interface EmployeeDao {  
	
	CustomGetAllResponse getEmployees(); 
	
	CustomPostResponse saveEmployee(Employee employee); 
	
	CustomGetResponse getSingleEmployee(Long id); 
	
	void deleteEmployee(Long id); 
	
	CustomPostResponse updateEmployee(Employee employee); 
	
	
}
