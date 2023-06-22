package springboot.jpa.api.exception;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class DetailsNotFoundException extends RuntimeException{
	

	private long httpStatus;
	private String message;
	private List<String> exception;
	
	
	public DetailsNotFoundException(long httpStatus, String message, List<String> exception) {
		super();
		this.httpStatus = httpStatus;
		this.message = message;
		this.exception = exception;
	}

	  
	  
}
