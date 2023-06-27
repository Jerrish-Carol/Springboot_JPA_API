package com.isteer.springbootjpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isteer.springbootjpa.model.Employee;

//JPA repository holds functions to create,read,update and delete
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> { //Entity name, datatype of primary key

	List<Employee>findByName(String Name); //To find a column or columns based on name
		//finder methods - findBy<field name> -> field name since DB column name is mapped to field name.

	//SELECT * FROM table WHERE name="bush" AND location="India"
	//List<Employee> findByNameAndLocation(String name, String location);

	//SELECT * FROM table WHERE name LIKE "%ram%"
	List<Employee> findByNameContaining(String keyword);
}
