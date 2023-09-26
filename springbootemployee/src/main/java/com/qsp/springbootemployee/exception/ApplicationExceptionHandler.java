package com.qsp.springbootemployee.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.qsp.springbootemployee.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	@ExceptionHandler(IdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundExceptionHandle(IdNotFound ex)
	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData("employee with given id not found");
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmailNotFound.class)
	public ResponseEntity<ResponseStructure<String>> emailNotFoundExceptionHandle(EmailNotFound ex)
	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData("employee with given email not found");
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(PhoneNotFound.class)
	public ResponseEntity<ResponseStructure<String>> phoneNotFoundExceptionHandle(PhoneNotFound ex)
	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData("employee with given phone not found");
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.BAD_REQUEST);
	}
	
	
	private ResponseEntity<Object>  handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders headers,HttpStatus 
			status,WebRequest request) {
		
		List<ObjectError> errors=ex.getAllErrors();
		Map<String, String> map =new HashMap<String ,String>();
		
		for(ObjectError objectError:errors)
		{
			FieldError error=(FieldError) objectError;
			String field=error.getField();
			String message=error.getDefaultMessage();
			map.put(field, message);
			
			
			
		}
		return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);

	}
	
	
	
	
	
	
	

}
