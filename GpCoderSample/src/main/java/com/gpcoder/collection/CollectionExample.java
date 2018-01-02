package com.gpcoder.collection;

import java.util.HashMap;
import java.util.Map;

public class CollectionExample {
	public static final int NUM_OF_ELEMENT = 5;

	public static void main(String[] args) {
		// Khởi tạo map
		Map<String, Integer> hashMap = new HashMap<>();
		for (int i = 1; i <= NUM_OF_ELEMENT; i++) {
			hashMap.put("Key0" + i, i);
		}
		
		// Duyệt các phần tử của map sử dụng phương thức keySet()
		System.out.println("Using keySet(): ");
		for (String key : hashMap.keySet()) {
			Integer value = hashMap.get(key);
			System.out.println(key + " = " + value);
		}

		// Duyệt các phần tử của map sử dụng phương thức entrySet()
		System.out.println("Using entrySet(): ");
		for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key + " = " + value);
		}
	}
}
