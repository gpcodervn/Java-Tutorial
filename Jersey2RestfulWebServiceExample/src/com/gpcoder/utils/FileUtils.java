package com.gpcoder.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;

public class FileUtils {
	
	private FileUtils() {
		super();
	}

	public static File storeFile(InputStream inputStream, String baseFolder, String fileName) {
		String extension = fileName.substring(fileName.lastIndexOf('.'));
		String name = fileName.substring(0, fileName.lastIndexOf('.'));
		String uploadedFilePath = baseFolder + "upload/" + name + "-" + System.currentTimeMillis() + extension;

		File uploadedFile = new File(Paths.get(uploadedFilePath).toAbsolutePath().toString());
		try (OutputStream outputStream = new FileOutputStream(uploadedFile)) {
			int read = 0;
			byte[] bytes = new byte[1024];
			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
			outputStream.flush();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return uploadedFile;
	}
}
