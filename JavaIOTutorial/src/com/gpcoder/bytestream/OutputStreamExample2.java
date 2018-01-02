package com.gpcoder.bytestream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamExample2 {

	public static void main(String[] args) throws IOException {
		// Tạo một luồng nhị phân đầu ra với mục đích ghi thông tin vào file
		OutputStream os = new FileOutputStream("data/output2.txt");

		// Tạo một mảng byte ,ta sẽ ghi các byte này vào file nói trên .
		byte[] b1 = new byte[] { 'g', 'p', 'c', 'o', 'd', 'e', 'r' };
		byte[] b2 = new byte[] { '.', 'c', 'o', 'm' };
		byte[] b3 = new byte[] { 13, 10 }; // Xuống dòng mới
		byte[] b4 = new byte[] { 'I', '/', 'O' };

		// Ghi cả các byte trong mảng byte[] by vào luồng
		os.write(b1);

		// Đẩy các byte hiện có trên luồng xuống file .
		os.flush();

		// Tiếp tục ghi các byte trong mảng thứ 2 vào luồng
		os.write(b2);
		os.write(b3);
		os.write(b4);

		// Đóng luồng vào công việc ghi thành công .
		os.close();
	}
}
