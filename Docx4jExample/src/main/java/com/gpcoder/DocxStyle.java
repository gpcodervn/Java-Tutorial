package com.gpcoder;

import org.docx4j.wml.JcEnumeration;
import org.docx4j.wml.STVerticalJc;

public class DocxStyle {
	private boolean bold;
	private boolean italic;
	private boolean underline;
	private String fontSize;
	private String fontColor;
	private String fontFamily;

	// cell margins
	private int left;
	private int bottom;
	private int top;
	private int right;

	private String background;
	private STVerticalJc verticalAlignment;
	private JcEnumeration horizAlignment;

	private boolean borderLeft;
	private boolean borderRight;
	private boolean borderTop;
	private boolean borderBottom;
	private boolean noWrap;

	public boolean isBold() {
		return bold;
	}

	public void setBold(boolean bold) {
		this.bold = bold;
	}

	public boolean isItalic() {
		return italic;
	}

	public void setItalic(boolean italic) {
		this.italic = italic;
	}

	public boolean isUnderline() {
		return underline;
	}

	public void setUnderline(boolean underline) {
		this.underline = underline;
	}

	public String getFontSize() {
		return fontSize;
	}

	public void setFontSize(String fontSize) {
		this.fontSize = fontSize;
	}

	public String getFontColor() {
		return fontColor;
	}

	public void setFontColor(String fontColor) {
		this.fontColor = fontColor;
	}

	public String getFontFamily() {
		return fontFamily;
	}

	public void setFontFamily(String fontFamily) {
		this.fontFamily = fontFamily;
	}

	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public int getBottom() {
		return bottom;
	}

	public void setBottom(int bottom) {
		this.bottom = bottom;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public STVerticalJc getVerticalAlignment() {
		return verticalAlignment;
	}

	public void setVerticalAlignment(STVerticalJc verticalAlignment) {
		this.verticalAlignment = verticalAlignment;
	}

	public JcEnumeration getHorizAlignment() {
		return horizAlignment;
	}

	public void setHorizAlignment(JcEnumeration horizAlignment) {
		this.horizAlignment = horizAlignment;
	}

	public boolean isBorderLeft() {
		return borderLeft;
	}

	public void setBorderLeft(boolean borderLeft) {
		this.borderLeft = borderLeft;
	}

	public boolean isBorderRight() {
		return borderRight;
	}

	public void setBorderRight(boolean borderRight) {
		this.borderRight = borderRight;
	}

	public boolean isBorderTop() {
		return borderTop;
	}

	public void setBorderTop(boolean borderTop) {
		this.borderTop = borderTop;
	}

	public boolean isBorderBottom() {
		return borderBottom;
	}

	public void setBorderBottom(boolean borderBottom) {
		this.borderBottom = borderBottom;
	}

	public boolean isNoWrap() {
		return noWrap;
	}

	public void setNoWrap(boolean noWrap) {
		this.noWrap = noWrap;
	}

}
