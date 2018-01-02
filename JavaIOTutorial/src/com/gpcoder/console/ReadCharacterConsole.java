package com.gpcoder.console;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class ReadCharacterConsole {

	public static void main(String[] args) throws IOException {
		Reader cin = null;
		try {
			cin = new InputStreamReader(System.in);
			System.out.println("Enter characters, 'q' to quit.");
			char c;
			do {
				c = (char) cin.read();
				System.out.print(c);
			} while (c != 'q');
		} finally {
			if (cin != null) {
				cin.close();
			}
		}
	}

}
