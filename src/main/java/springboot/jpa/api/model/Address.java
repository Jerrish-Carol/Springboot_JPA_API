package springboot.jpa.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
@Table(name="tbl_address") 
public class Address {
	
	@Id
	private long Address_ID;

	private long DoorNo;
	
	private String Street;
	
	private String State;
	
	private String City;
	
	
	public Address(long Address_ID, long doorNo, String street, String state, String city) {
		super();
		Address_ID = Address_ID;
		DoorNo = doorNo;
		Street = street;
		State = state;
		City = city;
		
	}
	
	

}
