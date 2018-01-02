package com.gpcoder.compress.jar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;

public class CreateJarFileExample {

	public static final String JAR_FILE = "C:/demo/gpcoder.jar";
	public static final String INPUT_FOLDER = "C:/demo/classes";
	public static final byte[] BUFFER = new byte[1024];

	public static void main(String[] args) throws IOException {
		File outputZipFile = new File(JAR_FILE);
		File inputDir = new File(INPUT_FOLDER);
		createJarFile(inputDir, outputZipFile);
	}

	/**
	 * Nén tất cả các tập tin và thư mục trong thư mục đầu vào 
	 * 
	 * @param inputDirThư mục đầu vào
	 * @param outputJarFile Tập tin đầu ra
	 */
	public static void createJarFile(File inputDir, File outputJarFile) {
		// Tạo thư mục cha cho file đầu ra (output file).
		outputJarFile.getParentFile().mkdirs();
		String inputDirPath = inputDir.getAbsolutePath();

		// prepare Manifest file
		String version = "1.0.0";
		String author = "gpcoder.com";
		Manifest manifest = new Manifest();
		Attributes global = manifest.getMainAttributes();
		global.put(Attributes.Name.MANIFEST_VERSION, version);
		global.put(new Attributes.Name("Created-By"), author);

		FileOutputStream fos = null;
		JarOutputStream jos = null;
		try {

			List<File> allFiles = listChildFiles(inputDir);

			// Tạo đối tượng JarOutputStream để ghi file jar.
			fos = new FileOutputStream(outputJarFile);
			jos = new JarOutputStream(fos, manifest);
			for (File file : allFiles) {
				String filePath = file.getAbsolutePath();

				System.out.println("Creating jar: " + filePath);
				// entryName: is a relative path.
				String entryName = filePath.substring(inputDirPath.length() + 1);

				// create JarEntry
				JarEntry je = new JarEntry(entryName);
				je.setComment("Creating Jar");
				je.setTime(Calendar.getInstance().getTimeInMillis());
				// Thêm entry vào file jar.
				jos.putNextEntry(je);

				// Đọc dữ liệu của file và ghi vào JarOutputStream.
				InputStream fileIs = new FileInputStream(filePath);
				int len;
				while ((len = fileIs.read(BUFFER)) > 0) {
					jos.write(BUFFER, 0, len);
				}
				fileIs.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeStream(jos);
			closeStream(fos);
		}

	}

	private static void closeStream(OutputStream out) {
		try {
			out.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Lấy danh sách các file trong thư mục: 
	 * 		bao gồm tất cả các file con, cháu,.. của thư mục đầu vào.
	 */
	private static List<File> listChildFiles(File dir) throws IOException {
		List<File> allFiles = new ArrayList<>();

		File[] childFiles = dir.listFiles();
		for (File file : childFiles) {
			if (file.isFile()) {
				allFiles.add(file);
			} else {
				List<File> files = listChildFiles(file);
				allFiles.addAll(files);
			}
		}
		return allFiles;
	}

}
