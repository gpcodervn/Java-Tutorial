package com.gpcoder.oop.keyword_this;

public class Helper {
	
	private UsingThisExample ex;
	
	public Helper(UsingThisExample ex) {
		this.ex = ex;
	}
	
	public void printId() {
		System.out.println("Id = " + ex.getId());
	}
	
	public void printWebsite() {
		System.out.println("Website = " + ex.getWebsite());
	}
	
}
