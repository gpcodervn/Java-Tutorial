package com.gpcoder.instance.objenesis;

public class ObjenesisDocumentGeneratorExample {

	public static void main(String[] args) throws ClassNotFoundException {
		Document document = new Document();
		document.setTitle("Doc1");
		document.setAuthor("gpcoder1");
		document.setClassName(Concrete1SelfDocumentGenerable.class.getCanonicalName());
		DocumentGenerator.generate(document);

		document = new Document();
		document.setTitle("Doc2");
		document.setAuthor("gpcoder2");
		document.setClassName(Concrete2SelfDocumentGenerable.class.getCanonicalName());
		DocumentGenerator.generate(document);
	}
}
