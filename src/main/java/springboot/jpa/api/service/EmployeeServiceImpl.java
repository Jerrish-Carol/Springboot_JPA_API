package springboot.jpa.api.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.jpa.api.repository.EmployeeRepository;
import springboot.jpa.api.response.CustomGetAllResponse;
import springboot.jpa.api.response.CustomGetResponse;
import springboot.jpa.api.response.CustomPostResponse;
import springboot.jpa.api.response.CustomSuccessResponse;
import springboot.jpa.api.exception.DetailsNotFoundException;
import springboot.jpa.api.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository eRepository;

	@Override
	public CustomGetAllResponse getEmployees() {
	
		return new CustomGetAllResponse(eRepository.findAll()); // you can find functions in eRepository by adding a dot after eRepository
	} 																							// findAll() - gets all the employee details

	@Override
	public CustomGetResponse getSingleEmployee(Long ID) {
		
		List<String> exception = new ArrayList<>();
		exception.add("BAD REQUEST");
		
		if (eRepository.findById(ID).isPresent()) {
			
			return new CustomGetResponse( eRepository.findById(ID).get()); // get employee details using this...optional is used																						// since content might be present in DB or not
			
			
		} else {
			throw new DetailsNotFoundException( 0,"NO DETAILS PROVIDED ", exception);
		}

	}

	@Override
	public void deleteEmployee(Long ID) {
		eRepository.deleteById(ID);

	}

	@Override
	public CustomPostResponse updateEmployee(Employee employee) {

		return new CustomPostResponse(1,"UPDATED",eRepository.save(employee));
	}

	/*@Override
	public CustomSuccessResponse getEmployeeByName(String name) {
		return new CustomSuccessResponse(1,"",eRepository.findByName(name));
	}

	/*
	 * @Override public List<Employee> getEmployeeByNameAndLocation(String name,
	 * String location) { return eRepository.findByNameAndLocation(name, location);
	 * }
	 */
/*
	@Override
	public CustomSuccessResponse getEmployeeByKeyword(String name) {

		return new CustomSuccessResponse(1,"",eRepository.findByNameContaining(name));
	}
	*/


	@Override
	public CustomPostResponse saveEmployee(Employee employee) {
		
		return new CustomPostResponse(1,"SAVED",eRepository.save(employee));
		
		
	}

	
	

}