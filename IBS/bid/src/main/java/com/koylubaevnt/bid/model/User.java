package com.koylubaevnt.bid.model;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = -3196026230478949426L;

	private Long id;
	
	private String lastName;
	
	private String firstName;
	
	private String email;
	
	public User() {
	}
	
	public User(String lastName, String firstName, String email) {
		this(null, lastName, firstName, email); 
	}
	
	public User(Long id, String lastName, String firstName, String email) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", email=" + email + "]";
	}
	
}
