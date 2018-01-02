package com.gpcoder.compress.zip;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipWithChecksum {

	public static final String OUTPUT_ZIP_FILE = "C:/demo/data-checksum.zip";
	public static final String SOURCE_FOLDER = "C:/demo/data";
	public static final byte[] BUFFER = new byte[1024];

	public static void main(String[] args) {
		File outputZipFile = new File(OUTPUT_ZIP_FILE);
		File inputDir = new File(SOURCE_FOLDER);
		zipDirectory(inputDir, outputZipFile);
	}

	/**
	 * Nén tất cả các tập tin và thư mục trong thư mục đầu vào
	 * 
	 * @param inputDir Thư mục đầu vào
	 * @param outputZipFile Tập tin đầu ra
	 */
	public static void zipDirectory(File inputDir, File outputZipFile) {
		// Tạo thư mục cha cho file đầu ra (output file).
		outputZipFile.getParentFile().mkdirs();

		String inputDirPath = inputDir.getAbsolutePath();

		FileOutputStream fos = null;
		ZipOutputStream zos = null;
		CheckedOutputStream checksum = null;
		try {

			List<File> allFiles = listChildFiles(inputDir);

			// Tạo đối tượng ZipOutputStream để ghi file zip.
			fos = new FileOutputStream(outputZipFile);

			// An output stream that also maintains a checksum of the data being
			// written. The checksum can then be used to verify the integrity of
			// the output data.
			checksum = new CheckedOutputStream(fos, new Adler32());
			zos = new ZipOutputStream(new BufferedOutputStream(checksum));

			for (File file : allFiles) {
				String filePath = file.getAbsolutePath();

				System.out.println("Zipping " + filePath);
				// entryName: is a relative path.
				String entryName = filePath.substring(inputDirPath.length() + 1);

				ZipEntry ze = new ZipEntry(entryName);
				// Thêm entry vào file zip.
				zos.putNextEntry(ze);
				// Đọc dữ liệu của file và ghi vào ZipOutputStream.
				FileInputStream fileIs = new FileInputStream(filePath);
				BufferedInputStream bis = new BufferedInputStream(fileIs, BUFFER.length);

				// read data to the end of the source file and write it to the zip
				// output stream.
				int length;
				while ((length = bis.read(BUFFER, 0, BUFFER.length)) > 0) {
					zos.write(BUFFER, 0, length);
				}
				fileIs.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeStream(zos);
			closeStream(fos);
		}

		// Print out checksum value
		if (checksum != null) {
			System.out.println("Checksum   : " + checksum.getChecksum().getValue());
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
	 * Lấy danh sách các file trong thư mục: bao gồm tất cả các file con, cháu,..
	 * của thư mục đầu vào.
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
