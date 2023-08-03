package com.isteer.springbootjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.isteer.springbootjpa.model.Address;

public interface AddressRepository extends JpaRepository <Address, Long> {

}


		