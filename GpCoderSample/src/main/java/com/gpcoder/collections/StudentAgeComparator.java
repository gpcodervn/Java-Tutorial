package com.gpcoder.collections;

import java.util.Comparator;

public class StudentAgeComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		// sort student's age by ASC
		if (o1.getAge() < o2.getAge()) {
			return -1;
		} else if (o1.getAge() == o2.getAge()) {
			return 0;
		} else {
			return 1;
		}
	}
}
