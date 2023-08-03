package com.isteer.springbootjpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
@Table(name = "tbl_address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="address_id")
	private long addressId;

	private long doorNo;

	private String street;

	private String state;

	private String city;

	public Address(long addressId, long doorNo, String street, String state, String city) {
		super();
		this.addressId = addressId;
		this.doorNo = doorNo;
		this.street = street;
		this.state = state;
		this.city = city;

	}

}
