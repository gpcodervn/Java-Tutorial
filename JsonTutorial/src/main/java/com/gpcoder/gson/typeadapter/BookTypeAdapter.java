package com.gpcoder.gson.typeadapter;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.gpcoder.gson.object.Book;

public class BookTypeAdapter extends TypeAdapter<Book> {

	public static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public Book read(final JsonReader in) throws IOException {
		final Book book = new Book();

		in.beginObject();
		while (in.hasNext()) {
			switch (in.nextName()) {
			case "title":
				book.setTitle(in.nextString());
				break;
			case "isbn-10":
				book.setIsbn10(in.nextString());
				break;
			case "isbn-13":
				book.setIsbn13(in.nextString());
				break;
			case "price":
				book.setPrice(in.nextDouble());
				break;
			case "publishedDate":
				Date publishedDate = null;
				try {
					publishedDate = sdf.parse(in.nextString());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				book.setPublishedDate(publishedDate);
				break;
			case "authors":
				in.beginArray();
				final List<String> authors = new ArrayList<>();
				while (in.hasNext()) {
					authors.add(in.nextString());
				}
				in.endArray();
				book.setAuthors(authors.toArray(new String[authors.size()]));
				break;
			}
		}
		in.endObject();

		return book;
	}

	@Override
	public void write(final JsonWriter out, final Book book) throws IOException {
		out.beginObject();
		out.name("title").value(book.getTitle());
		out.name("isbn-10").value(book.getIsbn10());
		out.name("isbn-13").value(book.getIsbn13());
		out.name("price").value(book.getPrice());
		out.name("publishedDate").value(sdf.format(book.getPublishedDate()));
		out.name("authors");
		out.beginArray();
		for (final String author : book.getAuthors()) {
			out.value(author);
		}
		out.endArray();
		out.endObject();
	}
}
