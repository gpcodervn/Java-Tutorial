package com.gpcoder.bytestream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamExample {

	public static void main(String[] args) throws IOException {
		// Tạo một luồng ký tự đầu ra với mục đích ghi thông tin vào file
		OutputStream os = new FileOutputStream("data/output.txt");

		// Tạo một mảng byte ,ta sẽ ghi các byte này vào file nói trên .
		byte[] by = new byte[] { 'g', 'p', 'c', 'o', 'd', 'e', 'r', '.', 'c', 'o', 'm' };

		// Ghi lần lượt các ký tự vào luồng
		for (int i = 0; i < by.length; i++) {
			byte b = by[i];
			// Ghi ký tự vào luồng
			os.write(b);
		}
		// Đóng luồng đầu ra lại việc ghi xuống file hoàn tất.
		os.close();
	}
}
