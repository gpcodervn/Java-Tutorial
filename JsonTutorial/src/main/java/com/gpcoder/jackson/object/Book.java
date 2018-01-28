package com.gpcoder.jackson.object;

import java.util.Arrays;
import java.util.Date;

public class Book {
	private String title;
	private String[] authors;
	private String isbn10;
	private String isbn13;
	private Double price;
	private Date publishedDate;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String[] getAuthors() {
		return authors;
	}

	public void setAuthors(String[] authors) {
		this.authors = authors;
	}

	public String getIsbn10() {
		return isbn10;
	}

	public void setIsbn10(String isbn10) {
		this.isbn10 = isbn10;
	}

	public String getIsbn13() {
		return isbn13;
	}

	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", authors=" + Arrays.toString(authors) + ", isbn10=" + isbn10 + ", isbn13="
				+ isbn13 + ", price=" + price + ", publishedDate=" + publishedDate + "]";
	}

}
