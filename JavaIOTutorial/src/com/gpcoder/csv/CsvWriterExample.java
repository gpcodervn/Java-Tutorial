package com.gpcoder.csv;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvWriterExample {
	// Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";

	// CSV file header
	private static final String FILE_HEADER = "id,code,name";

	public static void main(String[] args) {

		String fileName = "data/contries.csv";
		writeCsvFile(fileName);
	}

	public static void writeCsvFile(String fileName) {
		// Create new Countrys objects
		Country country1 = new Country(1, "US", "United States");
		Country country2 = new Country(2, "VN", "Viet Nam");
		Country country3 = new Country(3, "AU", "Australia");

		// Create a new list of Country objects
		List<Country> countries = new ArrayList<>();
		countries.add(country1);
		countries.add(country2);
		countries.add(country3);

		FileWriter fileWriter = null;

		try {
			fileWriter = new FileWriter(fileName);

			// Write the CSV file header
			fileWriter.append(FILE_HEADER);

			// Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);

			// Write a new Country object list to the CSV file
			for (Country country : countries) {
				fileWriter.append(String.valueOf(country.getId()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(country.getCode());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(country.getName());
				fileWriter.append(NEW_LINE_SEPARATOR);
			}

			System.out.println("CSV file was created successfully !!!");

		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
				e.printStackTrace();
			}
		}
	}
}
