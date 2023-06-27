package com.isteer.springbootjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import com.isteer.springbootjpa.model.Employee;
import com.isteer.springbootjpa.repository.EmployeeRepository;
import com.isteer.springbootjpa.response.CustomGetAllResponse;
import com.isteer.springbootjpa.response.CustomGetResponse;
import com.isteer.springbootjpa.response.CustomPostResponse;
import com.isteer.springbootjpa.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService eService;

	@Autowired
	private EmployeeRepository eRepository;

	@GetMapping("/employees")

	public ResponseEntity<CustomGetAllResponse> getEmployees() {
		return new ResponseEntity<CustomGetAllResponse>(eService.getEmployees(), HttpStatus.OK);
	}

	@GetMapping("/employees/{ID}")
	public ResponseEntity<CustomGetResponse> getEmployee(@PathVariable Long ID) {

		if (eService.getSingleEmployee(ID) != null) {
			return new ResponseEntity<CustomGetResponse>(eService.getSingleEmployee(ID), HttpStatus.ACCEPTED);

		} else {
			return new ResponseEntity<CustomGetResponse>(eService.getSingleEmployee(ID), HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/employees")

	public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam Long ID) {
		if (eService.getSingleEmployee(ID) != null) {
			eService.deleteEmployee(ID);
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/employees")

	public ResponseEntity<CustomPostResponse> saveEmployee(@Valid @RequestBody Employee employee) { // @RequestBody
																									// works with
																									// get,put,post so
																									// for
		return new ResponseEntity<CustomPostResponse>(eService.saveEmployee(employee), HttpStatus.CREATED);
	}

	@PutMapping("/employees/{ID}")
	public ResponseEntity<CustomPostResponse> updateEmployee(@PathVariable Long ID,
			@Valid @RequestBody Employee employee) {
		if (eRepository.existsById(ID)) {

			return new ResponseEntity<CustomPostResponse>(eService.saveEmployee(employee), HttpStatus.OK);
		}

		else {

			return new ResponseEntity<CustomPostResponse>(eService.saveEmployee(employee), HttpStatus.NO_CONTENT);
		}

	}

}
