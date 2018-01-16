package com.gpcoder.jackson.object;

public class Subject {
	public Subject() {
		super();
	}

	private String name;
	private float point;

	public Subject(String name, float point) {
		super();
		this.name = name;
		this.point = point;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPoint() {
		return point;
	}

	public void setPoint(float point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "Subject [name=" + name + ", point=" + point + "]";
	}

}
