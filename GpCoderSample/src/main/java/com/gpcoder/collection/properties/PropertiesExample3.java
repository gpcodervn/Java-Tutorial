package com.gpcoder.collection.properties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesExample3 {
	public static void main(String[] args) throws Exception {
		OutputStream output = null;
		try {
			// Properties File output
			output = new FileOutputStream("database.config.properties");

			// create properties object
			Properties prop = new Properties();

			// set the properties value
			prop.setProperty("database", "localhost");
			prop.setProperty("dbuser", "gpcoder");
			prop.setProperty("dbpassword", "password");

			// save properties to project root folder
			prop.store(output, "Config Database connection");
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}
}