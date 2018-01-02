package com.gpcoder.console;

import java.io.IOException;
import java.io.InputStream;

public class ReadByteConsole {

	public static void main(String[] args) throws IOException {
		InputStream is = System.in;
		while (true) {
			System.out.print("Nhập 1 ký tự: ");
			int ch = is.read();
			if (ch == 'q') {
				System.out.println("Finished!");
				break;
			}
			is.skip(2); // Loại bỏ 2 ký tự \r và \n
			System.out.println("Ký tự nhận được: " + (char) ch);
		}
	}
}
