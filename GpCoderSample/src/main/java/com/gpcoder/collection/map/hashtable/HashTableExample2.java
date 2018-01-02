package com.gpcoder.collection.map.hashtable;

import java.util.Hashtable;
import java.util.Map.Entry;

public class HashTableExample2 {
	public static void main(String args[]) {
		// Student's data
		Student student1 = new Student(1, "Student 1");
		Student student2 = new Student(2, "Student 2");
		Student student3 = new Student(3, "Student 3");

		// init Hashtable
		Hashtable<Integer, Student> hashTable = new Hashtable<Integer, Student>();
		hashTable.put(student1.getId(), student1);
		hashTable.put(student2.getId(), student2);
		hashTable.put(student3.getId(), student3);

		// show Hashtable using method keySet()
		for (Integer key : hashTable.keySet()) {
			Student value = hashTable.get(key);
			System.out.println(key + " = " + value);
		}

		System.out.println("---");

		// show Hashtable using method keySet()
		for (Entry<Integer, Student> entry : hashTable.entrySet()) {
			Integer key = entry.getKey();
			Student value = entry.getValue();
			System.out.println(key + " = " + value);
		}
	}

}
