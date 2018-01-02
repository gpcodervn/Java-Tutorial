package com.gpcoder.generic;

public class ContactEntryExample {
	public static void main(String[] args) {
		ContactEntry entry = new ContactEntry("gpcoder", 123456789);
		String name = entry.getKey();
		Integer id = entry.getValue();
		System.out.println("Name = " + name + ", Id = " + id); // Name = gpcoder, Id = 123456789
	}
}
