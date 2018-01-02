package com.gpcoder.exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class TryMultiResourceJava7Example {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		try (Reader reader = new FileReader("D:\\gpcoder.txt"); 
				BufferedReader br = new BufferedReader(reader)) {

			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}
	}
}
