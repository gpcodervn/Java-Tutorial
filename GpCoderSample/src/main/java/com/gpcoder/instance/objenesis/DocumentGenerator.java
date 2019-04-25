package com.gpcoder.instance.objenesis;

import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;
import org.objenesis.instantiator.ObjectInstantiator;

public class DocumentGenerator {

	public static void generate(Document document) throws ClassNotFoundException {
		Objenesis objenesis = new ObjenesisStd();
		Class<?> clazz = Class.forName(document.getClassName());
		ObjectInstantiator<?> instantiator = objenesis.getInstantiatorOf(clazz);
		SelfDocumentGenerable selfDocumentGenerable = (SelfDocumentGenerable) instantiator.newInstance();
		copyProperties(document, selfDocumentGenerable);
		selfDocumentGenerable.generateFile();
	}

	private static void copyProperties(Document src, Document target) {
		target.setTitle(src.getTitle());
		target.setAuthor(src.getAuthor());
	}
}
