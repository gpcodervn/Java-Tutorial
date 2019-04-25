package com.gpcoder.instance.objenesis;

public class Concrete2SelfDocumentGenerable extends SelfDocumentGenerable {

	public Concrete2SelfDocumentGenerable(String title, String author) {
		setTitle(title);
		setAuthor(author);
	}

	@Override
	public void generateFile() {
		System.out.printf("Concrete2: %s - %s\n", getTitle(), getAuthor());
	}
}
