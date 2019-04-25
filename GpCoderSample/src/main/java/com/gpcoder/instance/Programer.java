package com.gpcoder.instance;

public class Programer implements Cloneable {

	private int id;

	private String name;

	public Programer(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	protected Programer clone() throws CloneNotSupportedException {
		return (Programer) super.clone();
	}

	@Override
	public String toString() {
		return "Programer [id=" + id + ", name=" + name + "]";
	}
}
