package com.gpcoder.characterstream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadConsole {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.print("Enter your name: ");
			String name = br.readLine();
			if (name.equalsIgnoreCase("Exit")) {
				System.out.println("Finished!");
				break;
			}
			System.out.println("Hello " + name);
		}
	}
}
