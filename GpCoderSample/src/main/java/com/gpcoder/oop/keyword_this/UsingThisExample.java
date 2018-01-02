package com.gpcoder.oop.keyword_this;

public class UsingThisExample {
	private int id;
	private String website;
	
	UsingThisExample () {
		this.id = 1;
		this.website = "gpcoder";
	}
	
	public void print() {
		Helper helper = new Helper(this);
		helper.printId();	
		helper.printWebsite();
	}

	public int getId() {
		return id;
	}

	public String getWebsite() {
		return website;
	}
	
	public static void main(String[] args) {
		UsingThisExample ex = new UsingThisExample();
		ex.print();
	}
}
