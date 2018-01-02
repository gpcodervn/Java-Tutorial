package com.gpcoder.compress.gzip;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = -657143570052942947L;

	private Long id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;

	@Override
	public String toString() {
		return "User [id=" + id 
				+ ", username=" + username 
				+ ", password=" + password 
				+ ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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

}