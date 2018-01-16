package com.gpcoder.gson.typeadapter;

import java.io.IOException;
import java.util.Calendar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gpcoder.gson.object.Book;

public class GsonCustomTypeAdapterExample {

	public static void main(final String[] args) throws IOException {

		final GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Book.class, new BookTypeAdapter());
		gsonBuilder.setPrettyPrinting();

		final Gson gson = gsonBuilder.create();

		final Book book = new Book();
		book.setTitle("Head First Design Patterns");
		book.setIsbn10("0596007124");
		book.setIsbn13("978-0596007126");
		book.setPrice(52.41);

		Calendar c = Calendar.getInstance();
		c.set(2004, Calendar.OCTOBER, 1);
		book.setPublishedDate(c.getTime());

		String[] authors = new String[] { "Eric Freeman", "Bert Bates", "Kathy Sierra", "Elisabeth Robson" };
		book.setAuthors(authors);

		System.out.println("Convert Book object to JSON string: ");
		final String json = gson.toJson(book);
		System.out.println(json);

		System.out.println("Convert JSON String to Book object: ");
		final Book parsedBook = gson.fromJson(json, Book.class);
		System.out.println(parsedBook);
	}
}
