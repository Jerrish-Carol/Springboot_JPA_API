package springboot.jpa.api.exception;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.MethodNotAllowed;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;

@RestControllerAdvice // responsible to handle exception
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value = {DetailsNotFoundException.class})
	public ResponseEntity<Object>handleDetailsNotFoundException
	(DetailsNotFoundException detailsnotfoundexception){
		String StatusCode;
		
		CustomResponse customResponse = new CustomResponse(
   				
				StatusCode="0",
				
				detailsnotfoundexception.getMessage(),
				
				detailsnotfoundexception.getCause());
	
		return new ResponseEntity<>(customResponse,HttpStatus.NOT_FOUND);
			
		}
	

	
	@Override
	@ExceptionHandler(value = {ConstraintViolationException.class})
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		Map<String, String> response = new HashMap<>();
		exception.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName= ((FieldError)error).getField();
			String message = error.getDefaultMessage();
			response.put(fieldName, message);
			response.put("StatusCode","0");
			response.put("Exception","BAD REQUEST");
			
		});
		
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		
	}
	
	@Override
	@ExceptionHandler(value = {MethodNotAllowedException.class})
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException exception,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		Map<String, String> response = new HashMap<>();
		response.put("message", PAGE_NOT_FOUND_LOG_CATEGORY);
		
		response.put("exception", exception.getLocalizedMessage());
		
		response.put("StatusCode","0");
		
		return new ResponseEntity<>(response ,HttpStatus.BAD_REQUEST);
	}

	
	
}
	
	


	
	
	 
	 
	 