package com.gpcoder.oop.keyword_static;

public class UsingStaticExample {
	private String subject;
	
	UsingStaticExample (String subject) {
		this.subject = subject;
	}
	
	public void print() {
		System.out.println("Subject = " + subject);
		System.out.println("Website = " + MyWebsite.WEBSITE);
	}
	
	public static void changeWebsite(String website) {
		MyWebsite.WEBSITE = website;
	}
	
	public static void main(String[] args) {
		UsingStaticExample ex1 = new UsingStaticExample("Core Java");
		ex1.changeWebsite("http://gpcoder.com");
		ex1.print();
		System.out.println("----");
		UsingStaticExample ex2 = new UsingStaticExample("Object Oriented Programing");
		ex2.print();
	}
}
