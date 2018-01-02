package com.gpcoder.csv;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class ParseCsvToObjectUsingAnnotation {
	public static void main(String[] args) throws IOException {
		String csvFile = "data/data.csv";
		try (Reader reader = new FileReader(csvFile);) {
			CsvToBean<CountryAnn> csvToBean = new CsvToBeanBuilder<CountryAnn>(reader)
					.withType(CountryAnn.class)
	                .withSkipLines(1) // skip header
					.withIgnoreLeadingWhiteSpace(true)
					.build();

			List<CountryAnn> contries = csvToBean.parse();
			for (CountryAnn contry : contries) {
				System.out.println(contry);
			}
		}
	}
}
