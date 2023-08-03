package com.isteer.springbootjpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.isteer.springbootjpa.model.Employee;

//JPA Repository -> QueryUtils holds the built in SQL Queries

// Database configuration initialized in application.properties

public interface EmployeeRepository extends JpaRepository<Employee, Long> { //Entity name, datatype of primary key

	List<Employee>findByName(String name);

	List<Employee> findByNameContaining(String keyword);
}
