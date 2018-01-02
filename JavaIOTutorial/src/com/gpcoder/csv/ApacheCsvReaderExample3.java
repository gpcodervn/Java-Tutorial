package com.gpcoder.csv;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 * Reading a CSV file with Header Auto-detection (Access Values by Header names)
 */
public class ApacheCsvReaderExample3 {

	public static void main(String[] args) throws IOException {
		String csvFile = "data/data.csv";
		try (Reader reader = new FileReader(csvFile);
				CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
	                    .withFirstRecordAsHeader()
	                    .withIgnoreHeaderCase()
	                    .withTrim());) {

			for (CSVRecord csvRecord : csvParser.getRecords()) {
				// Accessing values by Header names
				System.out.println("Country [id= " + csvRecord.get(0) 
					+ ", code= " + csvRecord.get(1) 
					+ " , name=" + csvRecord.get(2) + "]");
			}
		}
	}
}