package com.gpcoder.csv;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.opencsv.CSVWriter;

public class OpenCsvWriterExmaple {

	public static void main(String[] args) throws IOException {
		String csv = "data/data.csv";
		try (Writer writer = new FileWriter(csv);
				CSVWriter csvWriter = new CSVWriter(writer, 
						CSVWriter.DEFAULT_SEPARATOR, 
						CSVWriter.NO_QUOTE_CHARACTER,
						CSVWriter.DEFAULT_ESCAPE_CHARACTER, 
						CSVWriter.DEFAULT_LINE_END);) {
			String[] headerRecord = { "id", "code", "name" };
			csvWriter.writeNext(headerRecord);

			csvWriter.writeNext(new String[] { "1", "US", "United States" });
			csvWriter.writeNext(new String[] { "2", "VN", "Viet Nam" });
			csvWriter.writeNext(new String[] { "3", "AU", "Australia" });
		}
	}
}
