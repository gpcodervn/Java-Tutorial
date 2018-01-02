package com.gpcoder.exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryResourceJava7Example {
	public static void main(String[] args) throws IOException {

		try (BufferedReader br = new BufferedReader(new FileReader("D:\\gpcoder.txt"))) {
			
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
