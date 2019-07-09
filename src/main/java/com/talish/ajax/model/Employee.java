package com.talish.ajax.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Employee {

	@NotEmpty(message="Enter your First Name")
	private String firstName;
	
	@NotEmpty(message="Enter your Last Name")
	private String lastName;
	
	@Email(message="Enter valid Email Id")
	private String email;
	
	@NotEmpty(message="Enter your designation")
	private String designation;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
}
