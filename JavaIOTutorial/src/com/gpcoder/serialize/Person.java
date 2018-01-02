package com.gpcoder.serialize;

import java.io.Serializable;

class Person implements Serializable {

	private static final long serialVersionUID = -5917089857953402554L;

	private int id;
	private String name;

	Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
}
