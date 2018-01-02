package com.gpcoder;

import java.io.File;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;

/**
 * HTML to Docx
 * http://www.baeldung.com/docx4j
 */
public class Write_HelloWorld {
	public static void main(String[] args) throws Docx4JException {
		WordprocessingMLPackage wordPackage = WordprocessingMLPackage.createPackage();
		MainDocumentPart mainDocumentPart = wordPackage.getMainDocumentPart();
		mainDocumentPart.addStyledParagraphOfText("Title", "Hello World!");
		mainDocumentPart.addParagraphOfText("Welcome To Baeldung");
		
		File exportFile = new File("output/welcome1.docx");
		wordPackage.save(exportFile);
		System.out.println("Done!");
	}
}
