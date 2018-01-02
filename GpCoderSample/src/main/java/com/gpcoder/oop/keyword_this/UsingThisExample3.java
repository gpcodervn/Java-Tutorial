package com.gpcoder.oop.keyword_this;

public class UsingThisExample3 {

	private int id;

	private String website;

	private String subject;

	public UsingThisExample3() {
		this.id = 1;
	}

	public UsingThisExample3 setWebsite(String website) {
		this.website = website;
		return this;
	}

	public UsingThisExample3 setSubject(String subject) {
		this.subject = subject;
		return this;
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
		UsingThisExample3 ex1 = new UsingThisExample3()
				.setSubject("OOP")
				.setWebsite("gpcoder.com");
		ex1.print();
	}

}
