package com.isteer.springbootjpa.model;


import java.time.LocalDate;
import java.util.*;
import org.springframework.beans.factory.annotation.Value;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


//This is an Entity class - It represents DB table in our application

@Data
@Getter
@Setter
@Entity  
@Table(name="tbl_employees") 	// mapping the database table here

public class Employee {
	
		@Id  //primary key
		@GeneratedValue(strategy = GenerationType.IDENTITY) // for auto-increment use GenerationType.AUTO for hibernate version 3 or 4 and this causes error in hibernate 5
														//This is hibernate version 5 so we use GenerationType.IDENTITY
														//@Column(name = "id")  //mapping column name from project to DB
		private long id;
	
														//@Column(name = "name") not required if field name is as same as column name
		@NotNull
		@Size(min = 4, message ="Username must be atleast 4 characters")
		private String name;
	
		@NotNull
		@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
		private LocalDate dob;
		
		@NotEmpty
		private String gender;
		
		
		@Value("${employee.isActive}")
		private Boolean isActive;
		
		
		@Value("${employee.isAccountLocked}")
		private Boolean isAccountLocked;
		
		@NotEmpty
		@Email(message ="email address is not valid")
		private String email;
		
		@NotEmpty
		private String department;
		
		
	    @OneToMany(cascade=CascadeType.ALL)
	    @JoinColumn(name = "fk_emp_id", referencedColumnName = "id")
	    // address object in employee class
		private List<Address> addressList ;
	


}
