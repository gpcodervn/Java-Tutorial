package com.gpcoder.generic;

public class KeyValuePairExample {
	public static void main(String[] args) {
		KeyValuePair<String, Integer> entry = new KeyValuePair<String, Integer>("gpcoder", 123456789);
		String name = entry.getKey();
		Integer id = entry.getValue();
		System.out.println("Name = " + name + ", Id = " + id); // Name = gpcoder, Id = 123456789
	}
}
