package springboot.jpa.api.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CustomResponse {

	private long StatusCode;

	private String message;
	
	private List<String> exception;

	
	
	public CustomResponse(long StatusCode, String message, List<String> exception ) {
		super();
		this.StatusCode = StatusCode;
		this.message = message;
		this.exception = exception;
	}
	
	
}
