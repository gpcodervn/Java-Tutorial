package com.gpcoder.console;

import java.io.IOException;

public class ReadByteConsole2 {

	public static void main(String[] args) throws IOException {
		while (true) {
			System.out.print("Nhập chuỗi ký tự: ");
			byte[] bytes = new byte[100]; // Tạo vùng đệm để nhập chuỗi
			int length = System.in.read(bytes);
			String str = new String(bytes, 0, length - 2);
			if (str.equalsIgnoreCase("EXIT")) {
				System.out.println("Finished!");
				break;
			}
			System.out.println("Chuỗi nhận được: " + str);
		}
	}
}
