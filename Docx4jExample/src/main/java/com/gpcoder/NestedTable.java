package com.gpcoder;

import java.math.BigInteger;
import org.docx4j.XmlUtils;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.CTTblPrBase.TblStyle;
import org.docx4j.wml.ObjectFactory;
import org.docx4j.wml.Tbl;
import org.docx4j.wml.TblPr;
import org.docx4j.wml.TblWidth;
import org.docx4j.wml.Tc;
import org.docx4j.wml.TcPr;
import org.docx4j.wml.Tr;
import org.docx4j.wml.TrPr;

/**
 * http://kooroth.blogspot.com/2012/05/nested-table-using-docx4j-example.html
 */
public class NestedTable {
       // Johnson Kooroth
       // The innerTable can be XML or
       // you can create using 
       // Tbl tblCredProg = factory.createTbl();
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

	protected static void addTc(Tr tr, String text) {
		Tc tc = factory.createTc();
		TcPr tcPr = new TcPr();
		TblWidth width = new TblWidth();
		width.setType("dxa");
		width.setW(new BigInteger("3192"));
		tcPr.setTcW(width);
		tc.setTcPr(tcPr);
		tc.getEGBlockLevelElts().add(wordMLPackage.getMainDocumentPart().createParagraphOfText(text));
		tr.getEGContentCellContent().add(tc);
	}

	public static void main(String[] args) throws Exception {

		System.out.println("Creating package..");
		wordMLPackage = WordprocessingMLPackage.createPackage();

		Tbl tblCredProg = factory.createTbl();
		TblPr tblPr = new TblPr();

		TblStyle tblStyle = new TblStyle();
		tblStyle.setVal("TableGrid");

		tblPr.setTblStyle(tblStyle);
		tblCredProg.setTblPr(tblPr);

		TblWidth width = new TblWidth();
		width.setType("auto");
		width.setW(new BigInteger("0"));
		tblPr.setTblW(width);

		// create row 1
		Tr tr = factory.createTr();

		// col 1 of row 1
		addTc(tr, "A");
		// col 2 of row 1
		addTc(tr, "B");

		tblCredProg.getEGContentRowContent().add(tr);

		// create row 2
		Tr tr2 = factory.createTr();

		TrPr pr = new TrPr();
		tr2.setTrPr(pr);

		// col 1 of row 2

		Tc tc1 = factory.createTc();
		TcPr tcPr = new TcPr();
		TblWidth widtha = new TblWidth();
		widtha.setType("auto");
		widtha.setW(new BigInteger("0"));
		tcPr.setTcW(widtha);

		tc1.setTcPr(tcPr);
		tc1.getEGBlockLevelElts().add(XmlUtils.unmarshalString(tblXML));
		// The following is important or you may get a corrupted docx file
		tc1.getEGBlockLevelElts().add(wordMLPackage.getMainDocumentPart().createParagraphOfText(""));
		tr2.getEGContentCellContent().add(tc1);

		tblCredProg.getEGContentRowContent().add(tr2);

		// col2 of row 2
		addTc(tr2, "C");

		wordMLPackage.getMainDocumentPart().addObject(tblCredProg);
		// Now save it
		wordMLPackage.save(new java.io.File("output/NestedTable.docx"));

		System.out.println("Done.");

	}

}