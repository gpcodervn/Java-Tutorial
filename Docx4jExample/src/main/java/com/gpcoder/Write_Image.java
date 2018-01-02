package com.gpcoder;

import java.io.File;
import java.nio.file.Files;

import org.docx4j.dml.wordprocessingDrawing.Inline;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.BinaryPartAbstractImage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.Drawing;
import org.docx4j.wml.ObjectFactory;
import org.docx4j.wml.P;
import org.docx4j.wml.R;

/**
 * Xuất ảnh
 * http://www.baeldung.com/docx4j
 */
public class Write_Image {

	public static void main(String[] args) throws Exception {
		WordprocessingMLPackage wordPackage = WordprocessingMLPackage.createPackage();
		MainDocumentPart mainDocumentPart = wordPackage.getMainDocumentPart();
		mainDocumentPart.addStyledParagraphOfText("Title", "Hello World!");
		mainDocumentPart.addParagraphOfText("Welcome To Baeldung");

		File image = new File("resources/image.png");
		byte[] fileContent = Files.readAllBytes(image.toPath());
		BinaryPartAbstractImage imagePart = BinaryPartAbstractImage.createImagePart(wordPackage, fileContent);
		Inline inline = imagePart.createImageInline("Baeldung Image (filename hint)", "Alt Text", 1, 2, false);
		P Imageparagraph = addImageToParagraph(inline);
		mainDocumentPart.getContent().add(Imageparagraph);
		
		File exportFile = new File("output/welcome3.docx");
		wordPackage.save(exportFile);
		System.out.println("Done!");
	}

	private static P addImageToParagraph(Inline inline) {
		ObjectFactory factory = new ObjectFactory();
		P p = factory.createP();
		R r = factory.createR();
		p.getContent().add(r);
		Drawing drawing = factory.createDrawing();
		r.getContent().add(drawing);
		drawing.getAnchorOrInline().add(inline);
		return p;
	}

}
