package com.gpcoder.csv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class ParseCsvToBean {
	// the delimiter to use for separating entries
	private static final char DEFAULT_SEPARATOR = ',';
	
	// the character to use for quoted elements
	private static final char DEFAULT_QUOTE = '"';
	
	// the line number to skip for start reading 
	private static final int NUM_OF_LINE_SKIP = 1;
	
	public static void main(String[] args) throws FileNotFoundException {
		String csvFile = "data/data.csv";
		parseCSVtoBean(csvFile);
	}

	public static void parseCSVtoBean(String filename) throws FileNotFoundException {
		ColumnPositionMappingStrategy<Country> strategy = new ColumnPositionMappingStrategy<Country>();
        strategy.setType(Country.class);
        String[] columns = new String[] { "id", "code", "name" };
        strategy.setColumnMapping(columns);

        CsvToBean<Country> csvToBean = new CsvToBeanBuilder<Country>(new FileReader(filename))
                .withMappingStrategy(strategy)
                .withSeparator(DEFAULT_SEPARATOR)
                .withQuoteChar(DEFAULT_QUOTE)
                .withSkipLines(NUM_OF_LINE_SKIP) 
                .withIgnoreLeadingWhiteSpace(true) 
                .build();

		List<Country> countries = csvToBean.parse();
		for (Country country : countries) {
			System.out.println(country);
		}
	}
}
