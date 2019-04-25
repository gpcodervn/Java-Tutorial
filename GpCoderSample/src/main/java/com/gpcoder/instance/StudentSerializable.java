package com.gpcoder.instance;

import java.io.Serializable;

public class StudentSerializable implements Serializable {

	private static final long serialVersionUID = 1427461703707854023L;

	private int id;
	private String name;

	public StudentSerializable(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "StudentSerializable [id=" + id + ", name=" + name + "]";
	}
}