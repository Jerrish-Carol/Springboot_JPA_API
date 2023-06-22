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
	(DetailsNotFoundException exception){
		long StatusCode = exception.getHttpStatus();
		List<String> exceptions = exception.getException();
		String message = exception.getMessage();
		
		CustomResponse customResponse = new CustomResponse(StatusCode,message,exceptions);
	
		return new ResponseEntity<>(customResponse,HttpStatus.NOT_FOUND);
			
		}
	

	
	@Override
	@ExceptionHandler(value = {ConstraintViolationException.class})
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		List<String> exceptions = new ArrayList<>();
		exception.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName= ((FieldError)error).getField();
			String message = error.getDefaultMessage();
			exceptions.add(fieldName+" "+message);
			});
			CustomResponse customResponse = new CustomResponse(0,"BAD REQUEST",exceptions);
		
		return new ResponseEntity<>(customResponse,HttpStatus.BAD_REQUEST);
		
	}
	
	@Override
	@ExceptionHandler(value = {MethodNotAllowedException.class})
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException exception,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		Map<String, String> response = new HashMap<>();
		List<String> exceptions = new ArrayList<>();
		
		exceptions.add(exception.getLocalizedMessage());
		
		CustomResponse customResponse = new CustomResponse(0,PAGE_NOT_FOUND_LOG_CATEGORY,exceptions);
		
		return new ResponseEntity<>(response ,HttpStatus.BAD_REQUEST);
	}

	
	
}
	
	


	
	
	 
	 
	 