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
	private long Employee_ID;

	private long DoorNo;
	
	private String Street;
	
	private String State;
	
	private String City;
	
	@ManyToOne // since many address to one employee
	@JoinColumn(name="ID")  // join column with primary key in employee
	private Employee employee;
	
	public Address(long employee_ID, long doorNo, String street, String state, String city, Employee employee) {
		super();
		Employee_ID = employee_ID;
		DoorNo = doorNo;
		Street = street;
		State = state;
		City = city;
		this.employee = employee;
	}
	
	

}
