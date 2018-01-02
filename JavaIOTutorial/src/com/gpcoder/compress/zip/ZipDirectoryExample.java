package com.gpcoder.compress.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipDirectoryExample {

	public static final String OUTPUT_ZIP_FILE = "C:/demo/demo.zip";
	public static final String SOURCE_FOLDER = "C:/demo/data";
	public static final byte[] BUFFER = new byte[1024];

	public static void main(String[] args) {
        File outputZipFile = new File(OUTPUT_ZIP_FILE);
		File inputDir = new File(SOURCE_FOLDER);
		zipDirectory(inputDir, outputZipFile);
	}

	/**
	 * Nén tất cả các tập tin và thư mục trong thư mục đầu vào
	 * @param inputDir Thư mục đầu vào
	 * @param outputZipFile Tập tin đầu ra
	 */
	public static void zipDirectory(File inputDir, File outputZipFile) {
        // Tạo thư mục cha cho file đầu ra (output file).
        outputZipFile.getParentFile().mkdirs();
 
        String inputDirPath = inputDir.getAbsolutePath();
 
        FileOutputStream fos = null;
        ZipOutputStream zipOs = null;
        try {
 
            List<File> allFiles = listChildFiles(inputDir);
 
            // Tạo đối tượng ZipOutputStream để ghi file zip.
            fos = new FileOutputStream(outputZipFile);
            zipOs = new ZipOutputStream(fos);
            for (File file : allFiles) {
                String filePath = file.getAbsolutePath();
 
                System.out.println("Zipping " + filePath);
                // entryName: is a relative path.
                String entryName = filePath.substring(inputDirPath.length() + 1);
 
                ZipEntry ze = new ZipEntry(entryName);
                // Thêm entry vào file zip.
                zipOs.putNextEntry(ze);
                // Đọc dữ liệu của file và ghi vào ZipOutputStream.
                FileInputStream fileIs = new FileInputStream(filePath);
 
                int len;
                while ((len = fileIs.read(BUFFER)) > 0) {
                    zipOs.write(BUFFER, 0, len);
                }
                fileIs.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        	closeStream(zipOs);
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
