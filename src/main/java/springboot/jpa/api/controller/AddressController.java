package springboot.jpa.api.controller;

import java.util.List;

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
import springboot.jpa.api.model.Address;
import springboot.jpa.api.model.Employee;
import springboot.jpa.api.service.AddressService;
import springboot.jpa.api.service.EmployeeService;

@RestController
public class AddressController {

	@Autowired
	private AddressService aService;

	@GetMapping("/address") 

	public ResponseEntity<List<Address>> getAddress() {
		return new ResponseEntity<List<Address>>(aService.getAddress(), HttpStatus.OK); 
	}


	@GetMapping("/address/{Employee_ID}")

	public ResponseEntity<Address> getEmployee(@PathVariable Long Employee_ID) { 
		if (aService.getSingleAddress(Employee_ID) != null) { 
			return new ResponseEntity<>(aService.getSingleAddress(Employee_ID), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(aService.getSingleAddress(Employee_ID), HttpStatus.NOT_FOUND);
		}
	}


	@DeleteMapping("/address")
	
	public ResponseEntity<HttpStatus> deleteAddress(@RequestParam Long Employee_ID) {
		if (aService.getSingleAddress(Employee_ID) != null) {
			aService.deleteAddress(Employee_ID);
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/address")

	public ResponseEntity<Address> saveAddress(@Valid @RequestBody Address address) { 
																							
		return new ResponseEntity<>(aService.saveAddress(address), HttpStatus.CREATED);
	}

	@PutMapping("/address/{ID}")
	public ResponseEntity<Address> updateAddress(@PathVariable Long Employee_ID, @Valid @RequestBody Address address) { 

		if (aService.getSingleAddress(Employee_ID).getState()!=null) {
			return new ResponseEntity<Address>(aService.saveAddress(address), HttpStatus.OK);

		} else {
			return new ResponseEntity<Address>(aService.saveAddress(address), HttpStatus.NO_CONTENT);
		}

	
	}

}
