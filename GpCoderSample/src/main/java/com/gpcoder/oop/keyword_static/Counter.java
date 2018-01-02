package com.gpcoder.oop.keyword_static;

public class Counter {
	static int count = 0; 

	public Counter() {
		
	}
	
	public void visit() {
		count++;
		this.print();
	}
	
	public void print() {
		System.out.println("count = " + count);		
	}

	public static void main(String[] args) {
		Counter c1 = new Counter();
		c1.visit();
		Counter c2 = new Counter();
		c2.visit();
		Counter c3 = new Counter();
		c3.visit();
	}
}
