package com.talish.ajax.controller;

import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.talish.ajax.model.Employee;
import com.talish.ajax.model.EmployeeJsonResponse;

@Controller
public class EmployeeController {

	@GetMapping("/")
	public String employeeForm() {
		return "employeeForm";
	}
	
	@PostMapping(value="/saveEmployee", produces= { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody EmployeeJsonResponse saveEmployee(@Valid Employee employee, BindingResult result) {
		EmployeeJsonResponse response = new EmployeeJsonResponse();
			System.out.println("test"+"   "+employee.getEmail());
		   if(result.hasErrors()){
		         
		         //Get error message
		         Map<String, String> errors = result.getFieldErrors().stream()
		               .collect(
		                     Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)
		                 );
			 response.setValidated(false);
	         response.setErrorMessages(errors);
	      }else{
	         response.setValidated(true);
	         response.setEmployee(employee);
	      }
	      return response;
	   }
	}