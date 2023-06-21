package springboot.jpa.api.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

public class DetailsNotFoundException extends RuntimeException{
	
	
	private HttpStatus httpStatus;
	private String message;
	
	public DetailsNotFoundException(String message, HttpStatus httpStatus , Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DetailsNotFoundException(String message) {
		super(message);
		
	}
	  
	  
}
