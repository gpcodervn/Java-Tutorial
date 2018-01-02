package com.gpcoder.collection.map.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Java program to illustrate internal working of HashMap
 */
class Key {
	String key;

	Key(String key) {
		this.key = key;
	}

	@Override
	public int hashCode() {
		int hash = (int) key.charAt(0);
		System.out.println("hashCode for key: " + key + " = " + hash);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		return key.equals(((Key) obj).key);
	}
}

public class HashMapInternalWorking {
	public static void main(String[] args) {
		Map<Key, Integer> map = new HashMap<>(); 	// line 1
		map.put(new Key("vishal"), 20);				// line 2
		map.put(new Key("sachin"), 30);				// line 3
		map.put(new Key("vaibhav"), 40);			// line 4

		System.out.println();
		System.out.println("Value for key sachin: " + map.get(new Key("sachin"))); 		// line 5
		System.out.println("Value for key vaibhav: " + map.get(new Key("vaibhav"))); 	// line 6
	}
}
