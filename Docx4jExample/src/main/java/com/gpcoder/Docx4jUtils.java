package com.gpcoder;

import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;

import org.docx4j.dml.wordprocessingDrawing.Inline;
import org.docx4j.jaxb.Context;
import org.docx4j.model.structure.PageDimensions;
import org.docx4j.model.structure.PageSizePaper;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.BinaryPartAbstractImage;
import org.docx4j.wml.Body;
import org.docx4j.wml.BooleanDefaultTrue;
import org.docx4j.wml.CTBorder;
import org.docx4j.wml.CTShd;
import org.docx4j.wml.CTTblPrBase.TblStyle;
import org.docx4j.wml.CTVerticalJc;
import org.docx4j.wml.Color;
import org.docx4j.wml.Drawing;
import org.docx4j.wml.HpsMeasure;
import org.docx4j.wml.Jc;
import org.docx4j.wml.JcEnumeration;
import org.docx4j.wml.ObjectFactory;
import org.docx4j.wml.P;
import org.docx4j.wml.PPr;
import org.docx4j.wml.R;
import org.docx4j.wml.RFonts;
import org.docx4j.wml.RPr;
import org.docx4j.wml.STBorder;
import org.docx4j.wml.STVerticalJc;
import org.docx4j.wml.SectPr;
import org.docx4j.wml.SectPr.PgMar;
import org.docx4j.wml.Tbl;
import org.docx4j.wml.TblPr;
import org.docx4j.wml.TblWidth;
import org.docx4j.wml.Tc;
import org.docx4j.wml.TcMar;
import org.docx4j.wml.TcPr;
import org.docx4j.wml.TcPrInner.GridSpan;
import org.docx4j.wml.TcPrInner.TcBorders;
import org.docx4j.wml.TcPrInner.VMerge;
import org.docx4j.wml.Text;
import org.docx4j.wml.Tr;
import org.docx4j.wml.U;
import org.docx4j.wml.UnderlineEnumeration;

public class Docx4jUtils {

	private static WordprocessingMLPackage wordMLPackage;
	private static ObjectFactory factory;
	private static boolean landscape = false;

	public Docx4jUtils() throws Docx4JException {
		wordMLPackage = WordprocessingMLPackage.createPackage(PageSizePaper.A4, landscape);
		factory = Context.getWmlObjectFactory();

		Tbl table = createTableWithContent();
		wordMLPackage.getMainDocumentPart().addObject(table);
		wordMLPackage.save(new File("C:/Test.docx"));
	}

	/**
	 * Our createTableWithContent method follows (we use dxa values). There are 4
	 * rows, some cells with vertical merge, and some with horizontal merge.
	 */
	private Tbl createTableWithContent() {

		Tbl table = factory.createTbl();

		// for TEST: this adds borders to all cells
		TblPr tblPr = new TblPr();
		TblStyle tblStyle = new TblStyle();
		tblStyle.setVal("TableGrid");
		tblPr.setTblStyle(tblStyle);
		table.setTblPr(tblPr);

		Tr tableRow = factory.createTr();
		// a default table cell style
		DocxStyle defStyle = new DocxStyle();
		defStyle.setBold(false);
		defStyle.setItalic(false);
		defStyle.setUnderline(false);
		defStyle.setHorizAlignment(JcEnumeration.CENTER);

		// a specific table cell style
		DocxStyle style = new DocxStyle();
		style.setBold(true);
		style.setItalic(true);
		style.setUnderline(true);
		style.setFontSize("40");
		style.setFontColor("FF0000");
		style.setFontFamily("Book Antiqua");
		style.setTop(300);
		style.setBackground("CCFFCC");
		style.setVerticalAlignment(STVerticalJc.CENTER);
		style.setHorizAlignment(JcEnumeration.CENTER);
		style.setBorderTop(true);
		style.setBorderBottom(true);
		style.setNoWrap(true);

		addTableCell(tableRow, "Field 1", 3500, style, 1, null);
		// start vertical merge for Filed 2 and Field 3 on 3 rows
		addTableCell(tableRow, "Field 2", 3500, defStyle, 1, "restart");
		addTableCell(tableRow, "Field 3", 1500, defStyle, 1, "restart");
		table.getContent().add(tableRow);

		tableRow = factory.createTr();
		addTableCell(tableRow, "Text", 3500, defStyle, 1, null);
		addTableCell(tableRow, "", 3500, defStyle, 1, "");
		addTableCell(tableRow, "", 1500, defStyle, 1, "");
		table.getContent().add(tableRow);

		tableRow = factory.createTr();
		addTableCell(tableRow, "Interval", 3500, defStyle, 1, null);
		addTableCell(tableRow, "", 3500, defStyle, 1, "close");
		addTableCell(tableRow, "", 1500, defStyle, 1, "close");
		table.getContent().add(tableRow);

		// add an image horizontally merged on 3 cells
		String filenameHint = null;
		String altText = null;
		int id1 = 0;
		int id2 = 1;
		byte[] bytes;
		try {
			bytes = getImageBytes(new File("/resources/image.png"));

			P pImage = newImage(wordMLPackage, bytes, filenameHint, altText, id1, id2, 8500);
			tableRow = factory.createTr();
			addTableCell(tableRow, pImage, 8500, defStyle, 3, null);
			table.getContent().add(tableRow);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return table;
	}

	private void addTableCell(Tr tableRow, P image, int width, DocxStyle style, int horizontalMergedCells,
			String verticalMergedVal) {
		Tc tableCell = factory.createTc();
		addImageCellStyle(tableCell, image, style);
		setCellWidth(tableCell, width);
		setCellVMerge(tableCell, verticalMergedVal);
		setCellHMerge(tableCell, horizontalMergedCells);
		tableRow.getContent().add(tableCell);
	}

	private void addCellStyle(Tc tableCell, String content, DocxStyle style) {
		if (style != null) {

			P paragraph = factory.createP();

			Text text = factory.createText();
			text.setValue(content);

			R run = factory.createR();
			run.getContent().add(text);

			paragraph.getContent().add(run);

			setHorizontalAlignment(paragraph, style.getHorizAlignment());

			RPr runProperties = factory.createRPr();

			if (style.isBold()) {
				addBoldStyle(runProperties);
			}
			if (style.isItalic()) {
				addItalicStyle(runProperties);
			}
			if (style.isUnderline()) {
				addUnderlineStyle(runProperties);
			}

			setFontSize(runProperties, style.getFontSize());
			setFontColor(runProperties, style.getFontColor());
			setFontFamily(runProperties, style.getFontFamily());

			setCellMargins(tableCell, style.getTop(), style.getRight(), style.getBottom(), style.getLeft());
			setCellColor(tableCell, style.getBackground());
			setVerticalAlignment(tableCell, style.getVerticalAlignment());

			setCellBorders(tableCell, style.isBorderTop(), style.isBorderRight(), style.isBorderBottom(),
					style.isBorderLeft());

			run.setRPr(runProperties);

			tableCell.getContent().add(paragraph);
		}
	}

	public P newImage(WordprocessingMLPackage wordMLPackage, byte[] bytes, String filenameHint, String altText, int id1,
			int id2, long cx) throws Exception {
		BinaryPartAbstractImage imagePart = BinaryPartAbstractImage.createImagePart(wordMLPackage, bytes);
		Inline inline = imagePart.createImageInline(filenameHint, altText, id1, id2, cx, false);
		// Now add the inline in w:p/w:r/w:drawing
		ObjectFactory factory = Context.getWmlObjectFactory();
		P p = factory.createP();
		R run = factory.createR();
		p.getContent().add(run);
		Drawing drawing = factory.createDrawing();
		run.getContent().add(drawing);
		drawing.getAnchorOrInline().add(inline);
		return p;
	}

	private void setCellBorders(Tc tableCell, boolean borderTop, boolean borderRight, boolean borderBottom,
			boolean borderLeft) {

		TcPr tableCellProperties = tableCell.getTcPr();
		if (tableCellProperties == null) {
			tableCellProperties = new TcPr();
			tableCell.setTcPr(tableCellProperties);
		}

		CTBorder border = new CTBorder();
		// border.setColor("auto");
		border.setColor("0000FF");
		border.setSz(new BigInteger("20"));
		border.setSpace(new BigInteger("0"));
		border.setVal(STBorder.SINGLE);

		TcBorders borders = new TcBorders();
		if (borderBottom) {
			borders.setBottom(border);
		}
		if (borderTop) {
			borders.setTop(border);
		}
		if (borderLeft) {
			borders.setLeft(border);
		}
		if (borderRight) {
			borders.setRight(border);
		}
		tableCellProperties.setTcBorders(borders);
	}

	private void setCellWidth(Tc tableCell, int width) {
		if (width > 0) {
			TcPr tableCellProperties = tableCell.getTcPr();
			if (tableCellProperties == null) {
				tableCellProperties = new TcPr();
				tableCell.setTcPr(tableCellProperties);
			}
			TblWidth tableWidth = new TblWidth();
			tableWidth.setType("dxa");
			tableWidth.setW(BigInteger.valueOf(width));
			tableCellProperties.setTcW(tableWidth);
		}
	}

	private void setCellNoWrap(Tc tableCell) {
		TcPr tableCellProperties = tableCell.getTcPr();
		if (tableCellProperties == null) {
			tableCellProperties = new TcPr();
			tableCell.setTcPr(tableCellProperties);
		}
		BooleanDefaultTrue b = new BooleanDefaultTrue();
		b.setVal(true);
		tableCellProperties.setNoWrap(b);
	}

	private void setCellVMerge(Tc tableCell, String mergeVal) {
		if (mergeVal != null) {
			TcPr tableCellProperties = tableCell.getTcPr();
			if (tableCellProperties == null) {
				tableCellProperties = new TcPr();
				tableCell.setTcPr(tableCellProperties);
			}
			VMerge merge = new VMerge();
			if (!"close".equals(mergeVal)) {
				merge.setVal(mergeVal);
			}
			tableCellProperties.setVMerge(merge);
		}
	}

	private void setCellHMerge(Tc tableCell, int horizontalMergedCells) {
		if (horizontalMergedCells > 1) {
			TcPr tableCellProperties = tableCell.getTcPr();
			if (tableCellProperties == null) {
				tableCellProperties = new TcPr();
				tableCell.setTcPr(tableCellProperties);
			}

			GridSpan gridSpan = new GridSpan();
			gridSpan.setVal(new BigInteger(String.valueOf(horizontalMergedCells)));

			tableCellProperties.setGridSpan(gridSpan);
			tableCell.setTcPr(tableCellProperties);
		}
	}

	private void setCellColor(Tc tableCell, String color) {
		if (color != null) {
			TcPr tableCellProperties = tableCell.getTcPr();
			if (tableCellProperties == null) {
				tableCellProperties = new TcPr();
				tableCell.setTcPr(tableCellProperties);
			}
			CTShd shd = new CTShd();
			shd.setFill(color);
			tableCellProperties.setShd(shd);
		}
	}

	private void setCellMargins(Tc tableCell, int top, int right, int bottom, int left) {
		TcPr tableCellProperties = tableCell.getTcPr();
		if (tableCellProperties == null) {
			tableCellProperties = new TcPr();
			tableCell.setTcPr(tableCellProperties);
		}
		TcMar margins = new TcMar();

		if (bottom > 0) {
			TblWidth bW = new TblWidth();
			bW.setType("dxa");
			bW.setW(BigInteger.valueOf(bottom));
			margins.setBottom(bW);
		}

		if (top > 0) {
			TblWidth tW = new TblWidth();
			tW.setType("dxa");
			tW.setW(BigInteger.valueOf(top));
			margins.setTop(tW);
		}

		if (left > 0) {
			TblWidth lW = new TblWidth();
			lW.setType("dxa");
			lW.setW(BigInteger.valueOf(left));
			margins.setLeft(lW);
		}

		if (right > 0) {
			TblWidth rW = new TblWidth();
			rW.setType("dxa");
			rW.setW(BigInteger.valueOf(right));
			margins.setRight(rW);
		}

		tableCellProperties.setTcMar(margins);
	}

	private void setVerticalAlignment(Tc tableCell, STVerticalJc align) {
		if (align != null) {
			TcPr tableCellProperties = tableCell.getTcPr();
			if (tableCellProperties == null) {
				tableCellProperties = new TcPr();
				tableCell.setTcPr(tableCellProperties);
			}

			CTVerticalJc valign = new CTVerticalJc();
			valign.setVal(align);

			tableCellProperties.setVAlign(valign);
		}
	}

	private void setFontSize(RPr runProperties, String fontSize) {
		if (fontSize != null && !fontSize.isEmpty()) {
			HpsMeasure size = new HpsMeasure();
			size.setVal(new BigInteger(fontSize));
			runProperties.setSz(size);
			runProperties.setSzCs(size);
		}
	}

	private void setFontFamily(RPr runProperties, String fontFamily) {
		if (fontFamily != null) {
			RFonts rf = runProperties.getRFonts();
			if (rf == null) {
				rf = new RFonts();
				runProperties.setRFonts(rf);
			}
			rf.setAscii(fontFamily);
		}
	}

	private void setFontColor(RPr runProperties, String color) {
		if (color != null) {
			Color c = new Color();
			c.setVal(color);
			runProperties.setColor(c);
		}
	}

	private void setHorizontalAlignment(P paragraph, JcEnumeration hAlign) {
		if (hAlign != null) {
			PPr pprop = new PPr();
			Jc align = new Jc();
			align.setVal(hAlign);
			pprop.setJc(align);
			paragraph.setPPr(pprop);
		}
	}

	private void addBoldStyle(RPr runProperties) {
		BooleanDefaultTrue b = new BooleanDefaultTrue();
		b.setVal(true);
		runProperties.setB(b);
	}

	private void addItalicStyle(RPr runProperties) {
		BooleanDefaultTrue b = new BooleanDefaultTrue();
		b.setVal(true);
		runProperties.setI(b);
	}

	private void addUnderlineStyle(RPr runProperties) {
		U val = new U();
		val.setVal(UnderlineEnumeration.SINGLE);
		runProperties.setU(val);
	}

	private void addImageCellStyle(Tc tableCell, P image, DocxStyle style) {
		setCellMargins(tableCell, style.getTop(), style.getRight(), style.getBottom(), style.getLeft());
		setCellColor(tableCell, style.getBackground());
		setVerticalAlignment(tableCell, style.getVerticalAlignment());
		setHorizontalAlignment(image, style.getHorizAlignment());
		setCellBorders(tableCell, style.isBorderTop(), style.isBorderRight(), style.isBorderBottom(),
				style.isBorderLeft());
		tableCell.getContent().add(image);
	}

	private void addTableCell(Tr tableRow, String content, int width, DocxStyle style, int horizontalMergedCells,
			String verticalMergedVal) {
		Tc tableCell = factory.createTc();
		addCellStyle(tableCell, content, style);
		setCellWidth(tableCell, width);
		setCellVMerge(tableCell, verticalMergedVal);
		setCellHMerge(tableCell, horizontalMergedCells);
		if (style.isNoWrap()) {
			setCellNoWrap(tableCell);
		}
		tableRow.getContent().add(tableCell);
	}

	/**
	 * Set document page margins to 50 pixels
	 */
	private void setPageMargins() {
		try {
			Body body = wordMLPackage.getMainDocumentPart().getContents().getBody();
			PageDimensions page = new PageDimensions();
			PgMar pgMar = page.getPgMar();
			pgMar.setBottom(BigInteger.valueOf(pixelsToDxa(50)));
			pgMar.setTop(BigInteger.valueOf(pixelsToDxa(50)));
			pgMar.setLeft(BigInteger.valueOf(pixelsToDxa(50)));
			pgMar.setRight(BigInteger.valueOf(pixelsToDxa(50)));
			SectPr sectPr = factory.createSectPr();
			body.setSectPr(sectPr);
			sectPr.setPgMar(pgMar);
		} catch (Docx4JException e) {
			e.printStackTrace();
		}
	}

	private static byte[] getImageBytes(File file) throws FileNotFoundException, IOException {
		byte[] bytes = null;
		// Our utility method wants that as a byte array
		if (file.exists() && file.isFile()) {
			java.io.InputStream is = new java.io.FileInputStream(file);
			long length = file.length();
			// You cannot create an array using a long type.
			// It needs to be an int type.
			bytes = new byte[(int) length];
			int offset = 0;
			int numRead = 0;
			while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
				offset += numRead;
			}
			// Ensure all the bytes have been read in
			if (offset < bytes.length) {
				// System.out.println("Could not completely read file
				// "+file.getName());
			}
			is.close();
		} else {
			bytes = new byte[0];
		}
		return bytes;
	}

	/**
	 * Microsoft docx uses a special measure unit called dxa which represents 1/20
	 * from a point. You should use following conversions:
	 * 
	 * 20 dxa = 1 point <br />
	 * 1440 dxa = 1 inch = 72 points
	 */
	// get dots per inch
	protected static int getDPI() {
		return GraphicsEnvironment.isHeadless() ? 96 : Toolkit.getDefaultToolkit().getScreenResolution();
	}

	private int pixelsToDxa(int pixels) {
		return (1440 * pixels / getDPI());
	}
}
