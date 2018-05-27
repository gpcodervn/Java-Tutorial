package com.gpcoder.consumer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumerExample {

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<>();
		map.put("Java", 5);
		map.put("PHP", 2);
		map.put("C#", 1);
		
		BiConsumer<String, Integer> biConsumer = 
				(key, value) -> System.out.println("Key: " + key + " - Value: " + value);
		map.forEach(biConsumer);
	}
}
