package com.isteer.springbootjpa.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.isteer.springbootjpa.repository.EmployeeRepository;
import com.isteer.springbootjpa.response.CustomGetAllResponse;
import com.isteer.springbootjpa.response.CustomGetResponse;
import com.isteer.springbootjpa.response.CustomPostResponse;
import com.isteer.springbootjpa.exception.DetailsNotFoundException;
import com.isteer.springbootjpa.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository eRepository;

	@Override
	public CustomGetAllResponse getEmployees() {

		return new CustomGetAllResponse(eRepository.findAll());
	}

	@Override
	public CustomGetResponse getSingleEmployee(Long id) {

		List<String> exception = new ArrayList<>();
		exception.add("BAD REQUEST");

		if (eRepository.findById(id).isPresent()) {

			return new CustomGetResponse(eRepository.findById(id).get());

		} else {
			throw new DetailsNotFoundException(0, "NO DETAILS PROVIDED ", exception);
		}

	}

	@Override
	public void deleteEmployee(Long id) {
		eRepository.deleteById(id);

	}

	@Override
	public CustomPostResponse updateEmployee(Employee employee) {

		return new CustomPostResponse(1, "UPDATED", eRepository.save(employee));
	}

	@Override
	public CustomPostResponse saveEmployee(Employee employee) {

		return new CustomPostResponse(1, "SAVED", eRepository.save(employee));

	}

}