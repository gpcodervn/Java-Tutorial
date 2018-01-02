package com.gpcoder.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsExample4 {
	public static void main(String a[]) {
		// Create list
		List<Student2> students = new ArrayList<>();
		Student2 student1 = new Student2(1, "myname1", 15);
		Student2 student2 = new Student2(2, "myname2", 20);
		Student2 student3 = new Student2(3, "myname3", 17);
		Student2 student4 = new Student2(4, "myname4", 10);
		Student2 student5 = new Student2(5, "myname5", 19);
		Student2 student6 = new Student2(6, "myname6", 19);
		students.add(student3);
		students.add(student1);
		students.add(student2);
		students.add(student5);
		students.add(student4);

		// Không cần cung cấp bộ so sánh, bởi vì nó đã được cài đặt trong lớp Student2
		System.out.println("Maximum value: " + Collections.max(students));
		System.out.println("Minimum value: " + Collections.min(students));
		System.out.println("Index of student1 : " + Collections.binarySearch(students, student1));
		System.out.println("Index of student6 : " + Collections.binarySearch(students, student6));
		System.out.println("---");

		Collections.sort(students);
		System.out.println("Sorted ASC: ");
		print(students);

		Collections.reverse(students);
		System.out.println("Sorted DESC: ");
		print(students);

		Comparator<Student2> compareDesc = Collections.reverseOrder();
		Collections.sort(students, compareDesc);
		System.out.println("Sorted DESC: ");
		print(students);

		Comparator<Student2> compareAsc = Collections.reverseOrder(compareDesc);
		Collections.sort(students, compareAsc);
		System.out.println("Sorted ASC: ");
		print(students);
	}

	private static void print(List<Student2> students) {
		for (Student2 student : students) {
			System.out.println(student);
		}
		System.out.println("---");
	}
}
