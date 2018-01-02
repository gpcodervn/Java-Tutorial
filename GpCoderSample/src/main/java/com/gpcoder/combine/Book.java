package com.gpcoder.combine;

@XmlRootElement(name = "book")
public class Book {

	@XmlElement(name = "name")
	private String name;

	@XmlElement(name = "author")
	private String author;

	@XmlElement(name = "publisher")
	private String publisher;

	@XmlAttribute(name = "isbn")
	private String isbn;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", author=" + author + ", publisher=" + publisher + ", isbn=" + isbn + "]";
	}

}
