package springboot.jpa.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import springboot.jpa.api.exception.CustomExceptionHandler;
import springboot.jpa.api.exception.DetailsNotFoundException;
import springboot.jpa.api.model.Employee;
import springboot.jpa.api.service.EmployeeService;

@RestController // @Controller + @ResponseBody
				// @Controller
/*
 * controller annotation - server will send all the HTTP request to these
 * classes
 */
public class EmployeeController {

	@Autowired
	private EmployeeService eService;

	/*
	 * @Value("${app.name}") private String appName;
	 * 
	 * @Value("${app.version}") private String appVersion;
	 * 
	 * @GetMapping("/version") public String getAppDetails() { return
	 * appName+" - "+appVersion; }
	 */

	@GetMapping("/employees") // if we use RequestMethod.GET/PUT/POST we can use this annotation instead of
								// @requestMapping

	// @RequestMapping(value= "/employees", method= RequestMethod.GET) // in order
	// to map these handler methods to postman
	// parameters are URI and HttpMethod

	// @ResponseBody // returns the response i.e here it returns "displaying list of
	// employees"

	// ResponseEntity is used to return not only data but also status code and other
	// details

	// before ResponseEntity:
	/*
	 * public List<Employee> getEmployees() { //handler method return
	 * eService.getEmployees();
	 * 
	 * }
	 */

	// After ResponseEntity: just adding stuff...no deletion and all ->

	public ResponseEntity<List<Employee>> getEmployees() { // handler method
		return new ResponseEntity<List<Employee>>(eService.getEmployees(), HttpStatus.OK); // if it success OK -200
	}

//localhost:8080/employees/<id>
	@GetMapping("/employees/{ID}")

	public ResponseEntity<Employee> getEmployee(@PathVariable /* ("id") */ Long ID) { // pathvariable is the variable
																						// that is given in URL
		if (eService.getSingleEmployee(ID) != null) { // Long - datatype id - variable // if /employees/{id} - id is the
														// same as in @PathVariable("id") then change it to -> public
														// String getEmployee(@PathVariable Long id)
			return new ResponseEntity<>(eService.getSingleEmployee(ID), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(eService.getSingleEmployee(ID), HttpStatus.NOT_FOUND);
		}
	}

//localhost:8080/employees?id=<> to add more parameters add & and include foreg: &user=<>
	@DeleteMapping("/employees")
	/*
	 * public void deleteEmployee(@RequestParam//("id")// Long id) { // if Long id -
	 * id is the same as in @RequestParam("id") then change it to
	 * -> @RequestParamLong id eService.deleteEmployee(id); }
	 */
	public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam Long ID) {
		if (eService.getSingleEmployee(ID) != null) {
			eService.deleteEmployee(ID);
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/employees")

	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) { // @RequestBody works with
																							// get,put,post so for
		return new ResponseEntity<>(eService.saveEmployee(employee), HttpStatus.CREATED);
	}

	@PutMapping("/employees/{ID}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long ID, @Valid @RequestBody Employee employee) { // @RequestBody
																													// works
																													// with
																													// get,put,post
																													// so
																													// for

		if (!eService.getSingleEmployee(ID).getIsAccountLocked()) {
			return new ResponseEntity<Employee>(eService.saveEmployee(employee), HttpStatus.OK);

		} else {
			return new ResponseEntity<Employee>(eService.saveEmployee(employee), HttpStatus.NO_CONTENT);
		}

	}

	@GetMapping("/employees/filterByName")
	public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name) {
		return new ResponseEntity<List<Employee>>(eService.getEmployeeByName(name), HttpStatus.OK);

	}

	@GetMapping("/employees/filterByKeyword")
	public ResponseEntity<List<Employee>> getEmployeesByKeyword(@RequestParam String name) {

		return new ResponseEntity<List<Employee>>(eService.getEmployeeByKeyword(name), HttpStatus.OK);

	}

}
