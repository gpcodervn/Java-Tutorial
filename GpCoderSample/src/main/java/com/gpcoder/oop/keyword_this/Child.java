package com.gpcoder.oop.keyword_this;

public class Child extends Parent {
	
	public String website = "https://gpcoder.com";
	
	public Child() {
		
	}
	
	public void printParent() {
		System.out.println("Short link: " + super.website);
		System.out.println("Subject " + subject);
	}
	
	public void printChild() {
		System.out.println("Full link: " + website);
		System.out.println("Subject " + subject);
	}
	
	public static void main(String[] args) {
		Child child = new Child();
		child.printParent();
		System.out.println("---");
		child.printChild();
	}
}
