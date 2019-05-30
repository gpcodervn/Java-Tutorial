package com.gpcoder.ws.document;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

public class DocumentUtils {

	private DocumentUtils() {
		super();
	}

	public static void storeDataToFile(DataHandler dataHandler, String fileName) {
		try {
			File file = new File(fileName);
			OutputStream os = new FileOutputStream(file);
			dataHandler.writeTo(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static DataHandler getFileAsDataHandler(String fileName) {
		FileDataSource dataSource = new FileDataSource(fileName);
		return new DataHandler(dataSource);
	}
}
