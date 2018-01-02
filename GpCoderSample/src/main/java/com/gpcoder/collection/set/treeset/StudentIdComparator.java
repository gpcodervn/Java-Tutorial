package com.gpcoder.collection.set.treeset;

import java.util.Comparator;

public class StudentIdComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		// sort student's id by DESC
		return o2.getName().compareTo(o1.getName());
	}

}
