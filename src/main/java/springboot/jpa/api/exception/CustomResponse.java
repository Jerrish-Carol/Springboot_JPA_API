package springboot.jpa.api.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CustomResponse {
	
		
		private String StatusCode;

		private String message;
		
		private Throwable reason;

		
		
		public CustomResponse(String StatusCode, String message, Throwable reason) {
			super();
			this.StatusCode = StatusCode;
			this.message = message;
			this.reason = reason;
		}



		public CustomResponse(HttpStatus methodNotAllowed, String localizedMessage, String string) {
			// TODO Auto-generated constructor stub
		}

	

}
