package com.gpcoder.collection.map.hashtable;

import java.util.Hashtable;
import java.util.Map.Entry;

public class HashTableExample {
	public static void main(String args[]) {
		// init Hashtable
		Hashtable<Integer, String> hashTable = new Hashtable<Integer, String>();
		hashTable.put(1, "Basic java");
		hashTable.put(2, "OOP");
		hashTable.put(3, "Collection");

		// show Hashtable using method keySet()
		for (Integer key : hashTable.keySet()) {
			String value = hashTable.get(key);
			System.out.println(key + " = " + value);
		}

		System.out.println("---");

		// show map using method keySet()
		for (Entry<Integer, String> entry : hashTable.entrySet()) {
			Integer key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + " = " + value);
		}
	}
}
