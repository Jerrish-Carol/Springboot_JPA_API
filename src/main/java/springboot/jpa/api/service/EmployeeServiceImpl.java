package springboot.jpa.api.service;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import jakarta.validation.ConstraintViolationException;
import springboot.jpa.api.repository.EmployeeRepository;
import springboot.jpa.api.response.CustomSuccessResponse;
import springboot.jpa.api.exception.DetailsNotFoundException;
import springboot.jpa.api.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository eRepository;

	@Override
	public CustomSuccessResponse getEmployees() {
	
		return new CustomSuccessResponse(1, "SUCCESS" ,eRepository.findAll()); // you can find functions in eRepository by adding a dot after eRepository
	} 																							// findAll() - gets all the employee details

	@Override
	public CustomSuccessResponse getSingleEmployee(Long ID) {
		
		List<String> exception = new ArrayList<>();
		exception.add("BAD REQUEST");
		
		if (eRepository.findById(ID).isPresent()) {
			
			return new CustomSuccessResponse(1, "Employee with ID" ,eRepository.findById(ID).get()); // get employee details using this...optional is used																						// since content might be present in DB or not
			
			
		} else {
			throw new DetailsNotFoundException( 0,"No Employee of the ID provided ", exception);
		}

	}

	@Override
	public void deleteEmployee(Long ID) {
		eRepository.deleteById(ID);

	}

	@Override
	public CustomSuccessResponse updateEmployee(Employee employee) {

		return new CustomSuccessResponse(1, "Employee with ID" ,eRepository.save(employee));
	}

	@Override
	public CustomSuccessResponse getEmployeeByName(String name) {
		return new CustomSuccessResponse(1, "Employee with ID" ,eRepository.findByName(name));
	}

	/*
	 * @Override public List<Employee> getEmployeeByNameAndLocation(String name,
	 * String location) { return eRepository.findByNameAndLocation(name, location);
	 * }
	 */

	@Override
	public CustomSuccessResponse getEmployeeByKeyword(String name) {

		return new CustomSuccessResponse(1, "Employee with ID" ,eRepository.findByNameContaining(name));
	}


	@Override
	public CustomSuccessResponse saveEmployee(Employee employee) {
		
		return new CustomSuccessResponse(1, "Employee with ID" ,eRepository.save(employee));
		
		
	}



	

}