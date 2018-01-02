package com.gpcoder.characterstream;

import java.io.ByteArrayInputStream;
import java.io.PushbackInputStream;

public class PushbackInputStreamExample {
	public static void main(String[] args) throws Exception {
		String srg = "1##2#34###12";
		byte[] byteArr = srg.getBytes();
		ByteArrayInputStream array = new ByteArrayInputStream(byteArr);
		PushbackInputStream push = new PushbackInputStream(array);
		int i;
		while ((i = push.read()) != -1) {
			// Tìm thấy ký tự '#'
			if (i == '#') {
				int j;
				// Đọc tiếp một ký tự nữa
				if ((j = push.read()) == '#') {
					System.out.print("**");
				} else {
					// Đẩy trở lại (Pushes back) ký tự này lên luồng.
					// Giống như lùi con trỏ trở lại 1 vị trí.
					push.unread(j);
					System.out.print((char) i);
				}
			} else {
				System.out.print((char) i);
			}
		}
	}
}
