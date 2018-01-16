package com.gpcoder.gson.custom;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.gpcoder.gson.object.Book;

public class BookDeserializer implements JsonDeserializer<Book> {

	public static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Book deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		
		final JsonObject jsonObject = json.getAsJsonObject();

		final String title = jsonObject.get("title").getAsString();
		final String isbn10 = jsonObject.get("isbn-10").getAsString();
		final String isbn13 = jsonObject.get("isbn-13").getAsString();
		final Double price = jsonObject.get("price").getAsDouble();
		
		// Write custom Date Deserializer
		Date publishedDate = null;
		try {
			publishedDate = sdf.parse(jsonObject.get("publishedDate").getAsString());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// Write custom Array Deserializer
		final JsonArray jsonAuthorsArray = jsonObject.get("authors").getAsJsonArray();
		final String[] authors = new String[jsonAuthorsArray.size()];
		for (int i = 0; i < authors.length; i++) {
			final JsonElement jsonAuthor = jsonAuthorsArray.get(i);
			authors[i] = jsonAuthor.getAsString();
		}

		final Book book = new Book();
		book.setTitle(title);
		book.setIsbn10(isbn10);
		book.setIsbn13(isbn13);
		book.setPrice(price);
		book.setPublishedDate(publishedDate);
		book.setAuthors(authors);
		return book;
	}

}
