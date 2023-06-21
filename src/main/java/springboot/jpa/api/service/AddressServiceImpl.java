package springboot.jpa.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.jpa.api.model.Address;
import springboot.jpa.api.model.Employee;
import springboot.jpa.api.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressRepository aRepository;

	@Override
	public List<Address> getAddress() {
		return aRepository.findAll();
		
	}  

	@Override
	public Address saveAddress(Address address) {
		return aRepository.save(address);
	}

	@Override
	public Address getAddress(Long Employee_ID) {
		return aRepository.findById(Employee_ID).get();
		
	}

	@Override
	public void deleteAddress(Long Employee_ID) {
		aRepository.deleteById(Employee_ID);
		
	}

	@Override
	public Address updateAddress(Address address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address getSingleAddress(Long employee_ID) {
		// TODO Auto-generated method stub
		return null;
	}

}
