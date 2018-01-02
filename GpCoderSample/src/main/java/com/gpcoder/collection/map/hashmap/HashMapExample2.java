package com.gpcoder.collection.map.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapExample2 {
	public static void main(String args[]) {
		// Student's data
		Student student1 = new Student(1, "Student 1");
		Student student2 = new Student(2, "Student 2");
		Student student3 = new Student(3, "Student 3");

		// init map
		Map<Integer, Student> map = new HashMap<Integer, Student>();
		map.put(student1.getId(), student1);
		map.put(student2.getId(), student2);
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
