package com.gpcoder.gson.object;

import com.google.gson.annotations.SerializedName;

public class Student {

	@SerializedName("id")
	private int studentId;

	@SerializedName("name")
	private String studentName;

	@SerializedName("clazz")
	private String clazzId;

	public Student() {
		super();
	}

	public Student(int studentId, String studentName, String clazzId) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.clazzId = clazzId;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", clazzId=" + clazzId + "]";
	}

}
