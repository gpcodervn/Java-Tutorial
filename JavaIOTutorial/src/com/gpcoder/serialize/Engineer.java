package com.gpcoder.serialize;

public class Engineer extends Person {

	private String certificate;

	public Engineer(int id, String name, String certificate) {
		super(id, name);
		this.certificate = certificate;
	}

	@Override
	public String toString() {
		return "Engineer [certificate=" + certificate + ", " + super.toString() + "]";
	}

}