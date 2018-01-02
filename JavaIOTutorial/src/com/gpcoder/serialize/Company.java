package com.gpcoder.serialize;

import java.io.Serializable;

public class Company implements Serializable {

	private static final long serialVersionUID = -3928260053430292056L;

	private int id;
	private String name;
	private Address address;// HAS-A

	public Company(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
