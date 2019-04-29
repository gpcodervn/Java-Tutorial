package com.gpcoder.example4_xml_config;

import org.apache.commons.chain.Catalog;
import org.apache.commons.chain.config.ConfigParser;
import org.apache.commons.chain.impl.CatalogFactoryBase;

/**
 * Get catalog from the XML configuration file
 */
public class MyXMLCatalog {

	private static final String CONFIG_FILE = "/chain-config.xml";
	private ConfigParser parser;
	private Catalog catalog;

	public MyXMLCatalog() {
		parser = new ConfigParser();
	}

	public Catalog getCatalog() throws Exception {
		if (catalog == null) {
			parser.parse(this.getClass().getResource(CONFIG_FILE));
		}
		catalog = CatalogFactoryBase.getInstance().getCatalog();
		return catalog;
	}
}