package com.gpcoder.datetime;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;

public class LocalDateExample {

	public static void main(String[] args) {

		// Current Date
		LocalDate today = LocalDate.now();
		System.out.println("Current Date = " + today);

		// Creating LocalDate by providing input arguments
		LocalDate firstDay_2014 = LocalDate.of(2014, Month.JANUARY, 1);
		System.out.println("Specific Date = " + firstDay_2014);

		// Try creating date by providing invalid inputs
		// LocalDate feb29_2014 = LocalDate.of(2014, Month.FEBRUARY, 29);
		// Exception in thread "main" java.time.DateTimeException:
		// Invalid date 'February 29' as '2014' is not a leap year

		// Current date in "Asia/Ho_Chi_Minh", you can get it from ZoneId javadoc
		LocalDate todayHCM = LocalDate.now(ZoneId.of("Asia/Ho_Chi_Minh"));
		System.out.println("Current Date in IST = " + todayHCM);

		// java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
		// LocalDate todayIST = LocalDate.now(ZoneId.of("IST"));

		// Getting date from the base date i.e 01/01/1970
		LocalDate dateFromBase = LocalDate.ofEpochDay(365);
		System.out.println("365th day from base date = " + dateFromBase);

		// Obtains an instance of LocalDate from a year and day-of-year
		LocalDate hundredDay2014 = LocalDate.ofYearDay(2014, 100);
		System.out.println("100th day of 2014 = " + hundredDay2014);
	}
}
