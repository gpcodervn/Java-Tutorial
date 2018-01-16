package com.gpcoder.gson.custom;

import java.util.Calendar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gpcoder.gson.object.Book;

public class GsonCustomSerializationExample {

	public static void main(String args[]) {

		final GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();
		// Register custom serializers / deserializers with GsonBuilder
		gsonBuilder.registerTypeAdapter(Book.class, new BookSerialiser());
		gsonBuilder.registerTypeAdapter(Book.class, new BookDeserializer());
		// format the JSON String
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
		String jsonString = gson.toJson(book);
		System.out.println(jsonString);

		System.out.println("Convert JSON String to Book object: ");
		Book book2 = gson.fromJson(jsonString, Book.class);
		System.out.println(book2);
	}
}
