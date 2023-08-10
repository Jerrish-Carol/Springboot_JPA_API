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

import com.isteer.springbootjpa.dao.EmployeeDao;
import com.isteer.springbootjpa.model.Employee;
import com.isteer.springbootjpa.repository.EmployeeRepository;
import com.isteer.springbootjpa.response.CustomGetAllResponse;
import com.isteer.springbootjpa.response.CustomGetResponse;
import com.isteer.springbootjpa.response.CustomPostResponse;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeDao eService;

	@Autowired
	private EmployeeRepository eRepository;

	@GetMapping("/employees")

	public ResponseEntity<CustomGetAllResponse> getEmployees() {
		return new ResponseEntity<>(eService.getEmployees(), HttpStatus.OK);
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<CustomGetResponse> getEmployee(@PathVariable Long id) {

		if (eService.getSingleEmployee(id) != null) {
			return new ResponseEntity<>(eService.getSingleEmployee(id), HttpStatus.ACCEPTED);

		} else {
			return new ResponseEntity<>(eService.getSingleEmployee(id), HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/employees")

	public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam Long id) {
		if (eService.getSingleEmployee(id) != null) {
			eService.deleteEmployee(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/employees")

	public ResponseEntity<CustomPostResponse> saveEmployee(@Valid @RequestBody Employee employee) { // @RequestBody works with get,put,post so
																									
		return new ResponseEntity<>(eService.saveEmployee(employee), HttpStatus.CREATED);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<CustomPostResponse> updateEmployee(@PathVariable Long id,
			@Valid @RequestBody Employee employee) {
		if (eRepository.existsById(id)) {

			return new ResponseEntity<>(eService.saveEmployee(employee), HttpStatus.OK);
		}

		else {

			return new ResponseEntity<>(eService.saveEmployee(employee), HttpStatus.NO_CONTENT);
		}

	}

}
