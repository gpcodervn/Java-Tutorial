package com.gpcoder.characterstream;

import java.io.CharArrayReader;
import java.io.PushbackReader;

public class PushbackReaderExample {
	public static void main(String[] args) throws Exception {
		char ary[] = { '1', '-', '-', '2', '-', '3', '4', '-', '-', '-', '5', '6' };
		CharArrayReader reader = new CharArrayReader(ary);
		PushbackReader push = new PushbackReader(reader);
		int i;
		while ((i = push.read()) != -1) {
			// Tìm thấy ký tự '-'
			if (i == '-') {
				int j;
				// Đọc tiếp một ký tự nữa
				if ((j = push.read()) == '-') {
					System.out.print("#*");
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
