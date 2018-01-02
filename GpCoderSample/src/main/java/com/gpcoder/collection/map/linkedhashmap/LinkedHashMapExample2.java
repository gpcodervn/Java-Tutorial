package com.gpcoder.collection.map.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LinkedHashMapExample2 {
	public static void main(String args[]) {
		// Student's data
		Student student1 = new Student(1, "Student 1");
		Student student2 = new Student(2, "Student 2");
		Student student3 = new Student(3, "Student 3");
		Student student4 = new Student(4, "Student 4");

		// init map
		Map<Integer, Student> map = new LinkedHashMap<Integer, Student>();
		map.put(student1.getId(), student1);
		map.put(student2.getId(), student2);
		map.put(student4.getId(), student4);
		map.put(student3.getId(), student3);

		// show map using method keySet()
		for (Integer key : map.keySet()) {
			Student value = map.get(key);
			System.out.println(key + " = " + value);
		}

		System.out.println("---");

		// show map using method keySet()
		for (Entry<Integer, Student> entry : map.entrySet()) {
			Integer key = entry.getKey();
			Student value = entry.getValue();
			System.out.println(key + " = " + value);
		}
	}

}
