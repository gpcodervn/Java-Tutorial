package com.gpcoder.collection.set.treeset;

import java.util.Comparator;

public class StudentNameComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		// sort student's name by ASC
		return o1.getName().compareTo(o2.getName());
	}

}
