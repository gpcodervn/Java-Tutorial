package com.gpcoder.oop.keyword_this;

public class UsingThisExample2 {

	private int id;

	private String website;

	private String subject;

	public UsingThisExample2() {
		this.id = 1;
		this.website = "https://gpcoder.com";
	}

	public UsingThisExample2(String website) {
		this(); // Bắt buộc phải dòng lệnh đầu tiên trong constructor
		this.website = website;
	}

	public UsingThisExample2(String website, String subject) {
		this(website); // Bắt buộc phải dòng lệnh đầu tiên trong constructor
		this.subject = subject;
	}

	public void print() {
		System.out.println("Id = " + id);
		this.printWebsite();
		this.printSubject();
	}

	private void printWebsite() {
		System.out.println("Subject = " + subject);
	}

	private void printSubject() {
		System.out.println("Website = " + website);
	}

	public static void main(String[] args) {
		UsingThisExample2 ex1 = new UsingThisExample2("gpcoder.com", "OOP");
		ex1.print();
	}

}
