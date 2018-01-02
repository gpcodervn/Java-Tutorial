package com.gpcoder.collection.list.arraylist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListToMapExample1 {
	public static void main(String[] args) {
		// create a list
		List<Book> books = new ArrayList<>();
		books.add(new Book(1, "Core Java"));
		books.add(new Book(2, "Data Structures & Algorithms"));

		// Print list book
		System.out.println("List books: ");
		for (Book book : books) {
			System.out.println(book);
		}
		System.out.println("---------------");

		// Convert list to map (before Java 8)
		Map<Integer, Book> map = new HashMap<>();
		for (Book book : books) {
			map.put(book.getId(), book);
		}

		// Print map book
		System.out.println("Map books: ");
		for (Map.Entry<Integer, Book> entry : map.entrySet()) {
			System.out.println(entry);
		}
	}
}
