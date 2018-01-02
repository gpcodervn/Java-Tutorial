package com.gpcoder.collection.queue;

import java.util.PriorityQueue;
import java.util.Queue;

class Book implements Comparable<Book> {
	private int id;
	private String name, author, publisher;
	private int quantity;

	public Book(int id, String name, String author, String publisher, int quantity) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.quantity = quantity;
	}

	@Override
	public int compareTo(Book b) {
		if (this.id > b.id) {
			return 1;
		} else if (this.id < b.id) {
			return -1;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author 
				+ ", publisher=" + publisher + ", quantity=" + quantity + "]";
	}

}

public class PriorityQueueDemo2 {
	public static void main(String[] args) {
		// Init PriorityQueue
		Queue<Book> queue = new PriorityQueue<Book>();
		// Creating Books
		Book b1 = new Book(121, "Let us C", "Yashwant Kanetkar", "BPB", 8);
		Book b2 = new Book(233, "Operating System", "Galvin", "Wiley", 6);
		Book b3 = new Book(101, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);
		// Adding Books to the queue
		queue.add(b1);
		queue.add(b2);
		queue.add(b3);
		System.out.println("Traversing the queue elements:");
		// Traversing queue elements
		for (Book b : queue) {
			System.out.println(b);
		}
		System.out.println("After removing one book record:");
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
	}
}