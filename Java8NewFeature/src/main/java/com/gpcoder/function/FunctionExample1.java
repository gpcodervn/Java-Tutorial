package com.gpcoder.function;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

public class FunctionExample1 {

	public static void main(String[] args) {

		Function<String, Integer> numberConverter = (str) -> Integer.parseInt(str);
		System.out.println(numberConverter.apply("1")); // 1

		Function<LocalDate, String> dateConverter = (d) -> d.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println(dateConverter.apply(LocalDate.now())); // 27/05/2018
	}
}
