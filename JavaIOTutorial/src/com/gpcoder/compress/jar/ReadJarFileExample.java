package com.gpcoder.compress.jar;

import java.io.FileInputStream;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.Manifest;

public class ReadJarFileExample {

	public static final String JAR_FILE = "C:/demo/gpcoder.jar";

	public static void main(String[] args) {
		JarInputStream zis = null;
		try {
			// Tạo đối tượng JarInputStream để đọc file jar.
			zis = new JarInputStream(new FileInputStream(JAR_FILE));

			// Đọc thông tin Manifest:
			Manifest manifest = zis.getManifest();
			Attributes atts = manifest.getMainAttributes();
			String version = atts.getValue("Manifest-Version");
			String createdBy = atts.getValue("Created-By");
			System.out.println("Manifest-Version:" + version);
			System.out.println("Created-By:" + createdBy);

			JarEntry entry = null;
			while ((entry = zis.getNextJarEntry()) != null) {
				if (entry.isDirectory()) {
					System.out.print("Folder: ");
				} else {
					System.out.print("File: ");
				}
				System.out.println(entry.getName());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				zis.close();
			} catch (Exception e) {
			}
		}
	}

}
