package com.gpcoder.datetime;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;

public class YearMonthExample {

	public static void main(String[] args) {

		// Year Example

		Year currentYear = Year.now();
		System.out.println("currentYear: " + currentYear); // 2018

		Year specifyYear = Year.of(2016);
		System.out.println("specifyYear: " + specifyYear); // 2016
		System.out.println("isLeap : " + specifyYear.isLeap()); // true

		int dayOfYear = 100;
		LocalDate localDate = currentYear.atDay(dayOfYear);
		System.out.println("localDate: " + localDate); // 2018-04-10

		// YearMonth Example

		YearMonth currentYearMonth = YearMonth.now();
		System.out.println("currentYearMonth: " + currentYearMonth);

		YearMonth specifyYearMonth = YearMonth.of(2016, 1);
		System.out.println("specifyYearMonth: " + specifyYearMonth);

		int dayOfMonth = 20;
		LocalDate localDate2 = currentYearMonth.atDay(dayOfMonth);
		System.out.println("localDate2: " + localDate2); // 2018-06-20

		// Year -> YearMonth

		YearMonth ym = currentYear.atMonth(5);
		System.out.println("ym: " + ym); // 2018-05
	}
}
