package com.gpcoder.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReaderExample {

	private static final String COMMA_DELIMITER = ","; // Split by comma

	public static void main(String[] args) {

		BufferedReader br = null;
		try {
			String line;
			br = new BufferedReader(new FileReader("data/contries.csv"));

			// How to read file in java line by line?
			while ((line = br.readLine()) != null) {
				printContry(parseCsvLine(line));
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException crunchifyException) {
				crunchifyException.printStackTrace();
			}
		}
	}

	public static List<String> parseCsvLine(String csvLine) {
		List<String> result = new ArrayList<String>();
		if (csvLine != null) {
			String[] splitData = csvLine.split(COMMA_DELIMITER);
			for (int i = 0; i < splitData.length; i++) {
				result.add(splitData[i]);
			}
		}
		return result;
	}

	private static void printContry(List<String> country) {
		System.out.println(
				"Country [id= " 
				+ country.get(0) 
				+ ", code= " + country.get(1) 
				+ " , name=" + country.get(2) 
				+ "]");
	}
}
