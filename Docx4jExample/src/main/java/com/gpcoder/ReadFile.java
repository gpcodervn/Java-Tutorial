package com.gpcoder;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.Text;

/**
 * Read file .docx 
 * http://www.baeldung.com/docx4j
 */
public class ReadFile {
	public static void main(String[] args) throws Docx4JException, JAXBException {
		File doc = new File("output/welcome1.docx");
		WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(doc);
		MainDocumentPart mainDocumentPart = wordMLPackage.getMainDocumentPart();
		String textNodesXPath = "//w:t"; // get all text nodes from the main document part
		List<Object> textNodes = mainDocumentPart.getJAXBNodesViaXPath(textNodesXPath, true);
		for (Object obj : textNodes) {
			Text text = (Text) ((JAXBElement) obj).getValue();
			String textValue = text.getValue();
			System.out.println(textValue);
		}
	}
}
