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
import springboot.jpa.api.exception.DetailsNotFoundException;
import springboot.jpa.api.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository eRepository;

	@Override
	public List<Employee> getEmployees() {
		return eRepository.findAll(); // you can find functions in eRepository by adding a dot after eRepository
	} // findAll() - gets all the employee details

	
	

	@Override
	public Employee getSingleEmployee(Long ID) {
		Optional<Employee> employee = eRepository.findById(ID); // get employee details using this...optional is used
																// since content might be present in DB or not
		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new DetailsNotFoundException("No Employee of the ID " + ID);
		}

	}

	@Override
	public void deleteEmployee(Long ID) {
		eRepository.deleteById(ID);

	}

	@Override
	public Employee updateEmployee(Employee employee) {

		return eRepository.save(employee);
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
		return eRepository.findByName(name);
	}

	/*
	 * @Override public List<Employee> getEmployeeByNameAndLocation(String name,
	 * String location) { return eRepository.findByNameAndLocation(name, location);
	 * }
	 */

	@Override
	public List<Employee> getEmployeeByKeyword(String name) {

		return eRepository.findByNameContaining(name);
	}


	@Override
	public Employee saveEmployee(Employee employee) {
		
			return eRepository.save(employee);
		
	}



	

}