package com.gpcoder.instance;

public class PrivateEmployee {

	private int id;

	private String name;

	private PrivateEmployee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "PrivateEmployee [id=" + id + ", name=" + name + "]";
	}
}