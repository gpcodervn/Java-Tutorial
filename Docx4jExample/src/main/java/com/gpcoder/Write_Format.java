package com.gpcoder;

import java.io.File;

import org.docx4j.jaxb.Context;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.BooleanDefaultTrue;
import org.docx4j.wml.Color;
import org.docx4j.wml.ObjectFactory;
import org.docx4j.wml.P;
import org.docx4j.wml.R;
import org.docx4j.wml.RPr;
import org.docx4j.wml.Text;

/**
 * Format: bold, italic, underline
 * http://www.baeldung.com/docx4j
 */
public class Write_Format {

	public static void main(String[] args) throws Docx4JException {
		WordprocessingMLPackage wordPackage = WordprocessingMLPackage.createPackage();
		MainDocumentPart mainDocumentPart = wordPackage.getMainDocumentPart();
		mainDocumentPart.addStyledParagraphOfText("Title", "Hello World!");
		mainDocumentPart.addParagraphOfText("Welcome To Baeldung");

		ObjectFactory factory = Context.getWmlObjectFactory();
		P p = factory.createP();
		R r = factory.createR();
		Text t = factory.createText();
		t.setValue("Welcome To Baeldung");
		r.getContent().add(t);
		p.getContent().add(r);
		RPr rpr = factory.createRPr();
		BooleanDefaultTrue b = new BooleanDefaultTrue();
		rpr.setB(b);
		rpr.setI(b);
		rpr.setCaps(b);
		Color green = factory.createColor();
		green.setVal("green");
		rpr.setColor(green);
		r.setRPr(rpr);
		mainDocumentPart.getContent().add(p);
		
		File exportFile = new File("output/welcome2.docx");
		wordPackage.save(exportFile);
		System.out.println("Done!");
	}

}
