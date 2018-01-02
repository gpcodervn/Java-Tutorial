package com.gpcoder.combine;

import java.util.ArrayList;
import java.util.List;

public class ObjectToXmlExample {

	public static void main(String[] args) {
		// create list
		List<Book> bookList = new ArrayList<Book>();

		// create books
		Book book1 = new Book();
		book1.setIsbn("978-0-13-708189-9");
		book1.setName("Core Java Volume I");
		book1.setAuthor("Horstmann, Cay S. and Cornell");
		book1.setPublisher("Oracle");
		bookList.add(book1);

		Book book2 = new Book();
		book2.setIsbn("978-3832180577");
		book2.setName("Spring MVC Beginner’s Guide");
		book2.setAuthor("Amuthan G");
		book2.setPublisher("Packt Pub");
		bookList.add(book2);

		Book book3 = new Book();
		book3.setIsbn("999-1234567890");
		book3.setName("Java 8 in Action");
		book3.setAuthor("Raoul-Gabriel Urma");
		book3.setPublisher("Manning Publications Co.");
		bookList.add(book3);

		// create bookstore, assigning book
		BookStore bookStore = new BookStore();
		bookStore.setName("Fraport Bookstore");
		bookStore.setLocation("Frankfurt Airport");
		bookStore.setBookList(bookList);

		System.out.println(bookStore);
		System.out.println("bookList: ");
		for (Book book : bookList) {
			System.out.println("+ " + book);
		}

		System.out.println("\nConvert to xml: \n");
		String xml = ObjectToXmlHelper.convertToXml(bookStore);
		System.out.println(xml);
	}

}
