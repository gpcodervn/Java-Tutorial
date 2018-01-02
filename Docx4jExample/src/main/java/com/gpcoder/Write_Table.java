package com.gpcoder;

import java.io.File;
import java.util.List;

import org.docx4j.jaxb.Context;
import org.docx4j.model.table.TblFactory;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.ObjectFactory;
import org.docx4j.wml.P;
import org.docx4j.wml.R;
import org.docx4j.wml.Tbl;
import org.docx4j.wml.Tc;
import org.docx4j.wml.Text;
import org.docx4j.wml.Tr;

/**
 * Export table
 * http://www.baeldung.com/docx4j
 */
public class Write_Table {

	public static void main(String[] args) throws Exception {
		WordprocessingMLPackage wordPackage = WordprocessingMLPackage.createPackage();
		MainDocumentPart mainDocumentPart = wordPackage.getMainDocumentPart();
		mainDocumentPart.addStyledParagraphOfText("Title", "Hello World!");
		mainDocumentPart.addParagraphOfText("Welcome To Baeldung");
		
		ObjectFactory factory = Context.getWmlObjectFactory();
		P p = factory.createP();
		R r = factory.createR();
		Text t = factory.createText();
		t.setValue("Cell data");
		r.getContent().add(t);
		p.getContent().add(r);

		int writableWidthTwips = wordPackage.getDocumentModel().getSections().get(0).getPageDimensions()
				.getWritableWidthTwips();
		int columnNumber = 3;
		Tbl tbl = TblFactory.createTable(3, 3, writableWidthTwips / columnNumber);
		List<Object> rows = tbl.getContent();
		for (Object row : rows) {
			Tr tr = (Tr) row;
			List<Object> cells = tr.getContent();
			for (Object cell : cells) {
				Tc td = (Tc) cell;
				td.getContent().add(p);
			}
		}
		mainDocumentPart.getContent().add(tbl);

		File exportFile = new File("output/welcome4.docx");
		wordPackage.save(exportFile);
		System.out.println("Done!");
	}

}
