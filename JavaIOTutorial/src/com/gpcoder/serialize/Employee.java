package com.gpcoder.serialize;

import java.io.Serializable;

public class Employee implements Serializable {

	private static final long serialVersionUID = 6429893828167360962L;

	private int id;
	private String name;
	private static String company = "com.gpcoder"; // it won't be serialized

	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

	public static String getCompany() {
		return company;
	}
}
