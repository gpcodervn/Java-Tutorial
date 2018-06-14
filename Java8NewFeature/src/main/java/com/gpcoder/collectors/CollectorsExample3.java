package com.gpcoder.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Book {
	private Integer id;
	private String title;
	private Integer cagegoryId;

	public Book(Integer id, String title, Integer cagegoryId) {
		super();
		this.id = id;
		this.title = title;
		this.cagegoryId = cagegoryId;
	}

	public Integer getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Integer getCagegoryId() {
		return cagegoryId;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", cagegoryId=" + cagegoryId + "]";
	}

}

public class CollectorsExample3 {

	public static void main(String[] args) {
		List<Book> books = Arrays.asList( //
				new Book(1, "A", 1), //
				new Book(2, "B", 1), //
				new Book(3, "C", 2), //
				new Book(4, "D", 3), //
				new Book(5, "E", 1) //
		);

		// groupingBy
		Map<Integer, Set<Book>> groupingBy = books.stream()
				.collect(Collectors.groupingBy(Book::getCagegoryId, Collectors.toSet()));
		groupingBy.forEach((catId, booksInCat) -> System.out.println("Category " + catId + " : " + booksInCat.size()));

		// partitioningBy
		Map<Boolean, Set<Book>> partitioningBy = books.stream()
				.collect(Collectors.partitioningBy(b -> b.getCagegoryId() > 2, Collectors.toSet()));
		System.out.println(partitioningBy);
	}
}
