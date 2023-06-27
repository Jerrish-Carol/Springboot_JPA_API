package com.isteer.springbootjpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isteer.springbootjpa.model.Address;
import com.isteer.springbootjpa.model.Employee;

@Repository
public interface AddressRepository extends JpaRepository <Address, Long> {

}


		