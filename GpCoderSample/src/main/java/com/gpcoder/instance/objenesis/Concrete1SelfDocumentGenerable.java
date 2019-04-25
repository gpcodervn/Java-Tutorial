package com.gpcoder.instance.objenesis;

import java.util.Date;

public class Concrete1SelfDocumentGenerable extends SelfDocumentGenerable {

	private Date createdDate;

	public Concrete1SelfDocumentGenerable(String title, String author, Date createdDate) {
		setTitle(title);
		setAuthor(author);
		this.createdDate = createdDate;
	}

	@Override
	public void generateFile() {
		System.out.printf("Concrete1: %s - %s\n", getTitle(), getAuthor());
	}
}
