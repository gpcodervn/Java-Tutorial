package com.gpcoder;

import java.io.File;
import java.math.BigInteger;
import org.docx4j.XmlUtils;
import org.docx4j.dml.wordprocessingDrawing.Inline;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.BinaryPartAbstractImage;
import org.docx4j.wml.CTTblPrBase.TblStyle;
import org.docx4j.wml.TcPrInner.GridSpan;
import org.docx4j.wml.TcPrInner.VMerge;
import org.docx4j.wml.ObjectFactory;
import org.docx4j.wml.Tbl;
import org.docx4j.wml.TblPr;
import org.docx4j.wml.TblWidth;
import org.docx4j.wml.Tc;
import org.docx4j.wml.TcPr;
import org.docx4j.wml.Tr;
import org.docx4j.wml.TrPr;

/**
 * http://kooroth.blogspot.com/2012/05/docx4j-nested-table-vertical-merge.html
 */
public class ComplexTable{
    
    // The innerTable ( tblXML ) can be XML or
    // you can create using  Tbl mainTable = factory.createTbl();
    // as shown below
    
    static String tblXML = "<w:tbl xmlns:w=\"http://schemas.openxmlformats.org/wordprocessingml/2006/main\" " +
            "xmlns:v=\"urn:schemas-microsoft-com:vml\" " +
            "xmlns:wp=\"http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing\" " +
            "xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\">"
            +"<w:tblPr>"
            +"<w:tblStyle w:val=\"TableGrid\" />"
            +"<w:tblW w:w=\"0\" w:type=\"auto\" />"
            +"<w:tblLook w:val=\"04A0\" />"
        +"</w:tblPr>"
        +"<w:tblGrid>"
            +"<w:gridCol w:w=\"392\" />"
            +"<w:gridCol w:w=\"328\" />"
        +"</w:tblGrid>"
        +"<w:tr w:rsidR=\"005C211D\" w:rsidTr=\"005C211D\">"
            +"<w:tc>"
                +"<w:tcPr>"
                    +"<w:tcW w:w=\"392\" w:type=\"dxa\" />"
                +"</w:tcPr>"
                +"<w:p w:rsidR=\"005C211D\" w:rsidRDefault=\"005C211D\" w:rsidP=\"005C211D\">"
                    +"<w:r>"
                        +"<w:t>1</w:t>"
                    +"</w:r>"
                +"</w:p>"
            +"</w:tc>"
            +"<w:tc>"
                +"<w:tcPr>"
                    +"<w:tcW w:w=\"328\" w:type=\"dxa\" />"
                +"</w:tcPr>"
                +"<w:p w:rsidR=\"005C211D\" w:rsidRDefault=\"005C211D\" w:rsidP=\"005C211D\">"
                    +"<w:r>"
                        +"<w:t>2</w:t>"
                    +"</w:r>"
                +"</w:p>"
            +"</w:tc>"
        +"</w:tr>"
        +"<w:tr w:rsidR=\"005C211D\" w:rsidTr=\"005C211D\">"
            +"<w:trPr>"
                +"<w:trHeight w:val=\"70\" />"
            +"</w:trPr>"
            +"<w:tc>"
                +"<w:tcPr>"
                    +"<w:tcW w:w=\"392\" w:type=\"dxa\" />"
                +"</w:tcPr>"
                +"<w:p w:rsidR=\"005C211D\" w:rsidRDefault=\"005C211D\" w:rsidP=\"005C211D\">"
                    +"<w:r>"
                        +"<w:t>3</w:t>"
                    +"</w:r>"
                +"</w:p>"
            +"</w:tc>"
            +"<w:tc>"
                +"<w:tcPr>"
                    +"<w:tcW w:w=\"328\" w:type=\"dxa\" />"
                +"</w:tcPr>"
                +"<w:p w:rsidR=\"005C211D\" w:rsidRDefault=\"005C211D\" w:rsidP=\"005C211D\">"
                    +"<w:r>"
                        +"<w:t>4</w:t>"
                    +"</w:r>"
                +"</w:p>"
            +"</w:tc>"
        +"</w:tr>"
    +"</w:tbl>";
    
	static WordprocessingMLPackage wordMLPackage = null;
	static ObjectFactory factory = new ObjectFactory();

	private static void addTc(Tr tr, String label, String text, String width) {
		Tc tc = factory.createTc();
		TcPr tcPr = new TcPr();
		TblWidth tblwidth = new TblWidth();
		tblwidth.setType("dxa");
		tblwidth.setW(new BigInteger(width));
		tcPr.setTcW(tblwidth);
		tc.setTcPr(tcPr);

		tc.getEGBlockLevelElts().add(wordMLPackage.getMainDocumentPart().createParagraphOfText(text));
		tr.getEGContentCellContent().add(tc);
	}

	private static void addTcVMerge(Tr tr, String label, String text, String vMergeVal, String width) {
		Tc tc = factory.createTc();
		TcPr tcPr = new TcPr();
		TblWidth tblwidth = new TblWidth();
		tblwidth.setType("dxa");
		tblwidth.setW(new BigInteger(width));
		tcPr.setTcW(tblwidth);

		VMerge merge = new VMerge();
		if (vMergeVal != null) {
			merge.setVal(vMergeVal);
		}
		tcPr.setVMerge(merge);

		tc.setTcPr(tcPr);
		if (text != null) {
			tc.getEGBlockLevelElts().add(wordMLPackage.getMainDocumentPart().createParagraphOfText(text));
		}

		tr.getEGContentCellContent().add(tc);
	}

	public static void main(String[] args) throws Exception {

		System.out.println("Creating package..");
		wordMLPackage = WordprocessingMLPackage.createPackage();

		Tbl mainTable = factory.createTbl();
		TblPr tblPr = new TblPr();

		TblStyle tblStyle = new TblStyle();
		tblStyle.setVal("TableGrid");

		tblPr.setTblStyle(tblStyle);
		mainTable.setTblPr(tblPr);

		TblWidth width = new TblWidth();
		width.setType("auto");
		width.setW(new BigInteger("0"));
		tblPr.setTblW(width);

		// create row 1
		Tr tr = factory.createTr();

		// col 1 of row 1
		addTc(tr, "Ab", "Ab", "3192");
		// col 2 of row 1
		addTc(tr, "Ac", "Ac", "3192");

		// a vertically merged col
		addTcVMerge(tr, "test", "Vertical Merge", "restart", "9000");

		mainTable.getEGContentRowContent().add(tr);

		// create row 2
		Tr tr2 = factory.createTr();

		TrPr pr = new TrPr();
		tr2.setTrPr(pr);

		// col 1 of row 2

		Tc tc1 = factory.createTc();
		TcPr tcPr = new TcPr();
		TblWidth widtha = new TblWidth();
		widtha.setType("dxa");
		widtha.setW(new BigInteger("0"));
		tcPr.setTcW(widtha);

		tc1.setTcPr(tcPr);
		tc1.getEGBlockLevelElts().add(XmlUtils.unmarshalString(tblXML));
		// The following is important or you may get a corrupted docx file
		tc1.getEGBlockLevelElts().add(wordMLPackage.getMainDocumentPart().createParagraphOfText(""));
		tr2.getEGContentCellContent().add(tc1);

		mainTable.getEGContentRowContent().add(tr2);

		// col2 of row 2
		addTc(tr2, "bA", "bA", "3192");

		// end vertically merged col
		addTcVMerge(tr2, "", "", null, "9000");

		// create row 3
		Tr tr3 = factory.createTr();

		TrPr pr3 = new TrPr();
		tr3.setTrPr(pr3);

		Tc tc31 = factory.createTc();
		TcPr tcPr3 = new TcPr();
		TblWidth width31 = new TblWidth();
		width31.setType("dxa");
		width31.setW(new BigInteger("0"));
		tcPr3.setTcW(width31);

		// for setting colspan of 3
		GridSpan gridSpan = new GridSpan();
		gridSpan.setVal(new BigInteger("3"));

		tcPr3.setGridSpan(gridSpan);

		tc31.setTcPr(tcPr3);
		tc31.getEGBlockLevelElts()
				.add(wordMLPackage.getMainDocumentPart().createParagraphOfText("Horizontal merge 3 col"));

		tr3.getEGContentCellContent().add(tc31);
		mainTable.getEGContentRowContent().add(tr3);

		// create row 4 -6384
		Tr tr4 = factory.createTr();

		TrPr pr4 = new TrPr();
		tr4.setTrPr(pr4);

		Tc tc41 = factory.createTc();
		TcPr tcPr4 = new TcPr();
		TblWidth width41 = new TblWidth();
		width41.setType("dxa");
		width41.setW(new BigInteger("0"));
		tcPr4.setTcW(width31);

		// for setting colspan of 3
		GridSpan gridSpan41 = new GridSpan();
		gridSpan41.setVal(new BigInteger("2"));

		tcPr4.setGridSpan(gridSpan41);

		tc41.setTcPr(tcPr4);
		tc41.getEGBlockLevelElts()
				.add(wordMLPackage.getMainDocumentPart().createParagraphOfText("Horizontal merge 2 col"));

		tr4.getEGContentCellContent().add(tc41);

		// Add an image to the last col

		File file = new File("resources/image.png");

		java.io.InputStream is = new java.io.FileInputStream(file);

		long length = file.length();
		// You cannot create an array using a long type.
		// It needs to be an int type.
		if (length > Integer.MAX_VALUE) {
			System.out.println("File too large!!");
		}
		byte[] bytes = new byte[(int) length];
		int offset = 0;
		int numRead = 0;
		while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
			offset += numRead;
		}
		// Ensure all the bytes have been read in
		if (offset < bytes.length) {
			System.out.println("Could not completely read file " + file.getName());
		}
		is.close();

		String filenameHint = null;
		String altText = null;
		int id1 = 0;
		int id2 = 1;

		org.docx4j.wml.P p2 = newImage(wordMLPackage, bytes, filenameHint, altText, id1, id2, 3000);

		Tc tc42 = factory.createTc();
		tc42.getEGBlockLevelElts().add(p2);
		tr4.getEGContentCellContent().add(tc42);

		mainTable.getEGContentRowContent().add(tr4);

		wordMLPackage.getMainDocumentPart().addObject(mainTable);
		// Now save it
		wordMLPackage.save(new java.io.File("output/ComplexTable.docx"));

		System.out.println("Done.");

	}

	public static org.docx4j.wml.P newImage(WordprocessingMLPackage wordMLPackage, byte[] bytes, String filenameHint,
			String altText, int id1, int id2, long cx) throws Exception {

		BinaryPartAbstractImage imagePart = BinaryPartAbstractImage.createImagePart(wordMLPackage, bytes);

		Inline inline = imagePart.createImageInline(filenameHint, altText, id1, id2, cx);

		// Now add the inline in w:p/w:r/w:drawing
		org.docx4j.wml.ObjectFactory factory = new org.docx4j.wml.ObjectFactory();
		org.docx4j.wml.P p = factory.createP();
		org.docx4j.wml.R run = factory.createR();
		p.getParagraphContent().add(run);
		org.docx4j.wml.Drawing drawing = factory.createDrawing();
		run.getRunContent().add(drawing);
		drawing.getAnchorOrInline().add(inline);

		return p;

	}

}