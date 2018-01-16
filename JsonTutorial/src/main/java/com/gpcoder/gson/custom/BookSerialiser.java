package com.gpcoder.gson.custom;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.gpcoder.gson.object.Book;

public class BookSerialiser implements JsonSerializer<Book> {

	public static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public JsonElement serialize(Book book, Type typeOfSrc, JsonSerializationContext context) {
		final JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("title", book.getTitle());
		jsonObject.addProperty("isbn-10", book.getIsbn10());
		jsonObject.addProperty("isbn-13", book.getIsbn13());
		jsonObject.addProperty("price", book.getPrice());

		// Write custom Date Serializer
		final JsonPrimitive jsonDate = new JsonPrimitive(sdf.format(book.getPublishedDate()));
		jsonObject.add("publishedDate", jsonDate);

		// Write custom Array Serializer
		final JsonArray jsonAuthorsArray = new JsonArray();
		for (final String author : book.getAuthors()) {
			final JsonPrimitive jsonAuthor = new JsonPrimitive(author);
			jsonAuthorsArray.add(jsonAuthor);
		}
		jsonObject.add("authors", jsonAuthorsArray);

		return jsonObject;
	}

}
