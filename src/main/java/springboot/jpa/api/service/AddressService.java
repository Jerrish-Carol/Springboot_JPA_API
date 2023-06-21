package springboot.jpa.api.service;

import java.util.List;

import springboot.jpa.api.model.Address;
import springboot.jpa.api.model.Employee;

public interface AddressService {

	List<Address> getAddress(); 
	
	Address saveAddress(Address address) ; 
	
	Address getAddress(Long Employee_ID); 
	
	void deleteAddress(Long Employee_ID);
	
	Address updateAddress(Address address);

	Address getSingleAddress(Long employee_ID); 
	
	

}
