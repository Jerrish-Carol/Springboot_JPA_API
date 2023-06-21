package springboot.jpa.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.jpa.api.model.Address;
import springboot.jpa.api.model.Employee;

@Repository
public interface AddressRepository extends JpaRepository <Address, Long> {

}


		