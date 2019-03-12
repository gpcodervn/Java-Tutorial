package com.gpcoder.junit.hamcrest;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasXPath;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Test;
import org.w3c.dom.Document;

public class XmlMatcherExample {

	@Test
	public void test_xml_path () throws Exception {

	    String aListApartXML = 
	    		"<tutorials>" + 
	    		"  <tutorial>" + 
	    		"    <title lang=\"en\">JUnit</title>" + 
	    		"    <author>gpcoder.com</author>" + 
	    		"    <year>2019</year>" + 
	    		"  </tutorial>" + 
	    		"</tutorials>";

	    Document xml = parse(aListApartXML);

	    assertThat(xml, hasXPath("/tutorials/tutorial/author"));
	    assertThat(xml, hasXPath("/tutorials/tutorial/author", equalTo("gpcoder.com")));
	}

	private static Document parse(String xml) throws Exception {
	    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
	    documentBuilderFactory.setNamespaceAware(false);
	    DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
	    return documentBuilder.parse(new ByteArrayInputStream(xml.getBytes()));
	}
}
