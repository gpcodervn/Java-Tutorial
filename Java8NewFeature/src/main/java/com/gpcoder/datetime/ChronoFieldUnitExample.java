package com.gpcoder.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class ChronoFieldUnitExample {

	public static void main(String[] args) {

		// ====== ChronoUnit Example ======

		// Get the current date
		LocalDate today = LocalDate.now();
		System.out.println("Current date: " + today);

		// add 1 week to the current date
		LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
		System.out.println("Next week: " + nextWeek);

		// add 1 week to the current date
		LocalDate previousWeek = today.minus(1, ChronoUnit.WEEKS);
		System.out.println("Previous week: " + previousWeek);

		// add 1 month to the current date
		LocalDate nextMonth = today.plus(1, ChronoUnit.MONTHS);
		System.out.println("Next month: " + nextMonth);

		// add 1 year to the current date
		LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
		System.out.println("Next year: " + nextYear);

		// add 10 years to the current date
		LocalDate nextDecade = today.plus(1, ChronoUnit.DECADES);
		System.out.println("Date after ten years: " + nextDecade);

		// ====== ChronoField Example ======

		LocalDateTime currentDateTime = LocalDateTime.now();
		System.out.println("\ncurrentDateTime: " +currentDateTime);
		System.out.println("Year: " + currentDateTime.get(ChronoField.YEAR));
		System.out.println("Month: " + currentDateTime.get(ChronoField.MONTH_OF_YEAR));
		System.out.println("Day of month: " + currentDateTime.get(ChronoField.DAY_OF_MONTH));
		System.out.println("Hour of day: " + currentDateTime.get(ChronoField.HOUR_OF_DAY));
		System.out.println("Minute of hour: " + currentDateTime.get(ChronoField.MINUTE_OF_HOUR));
	}
}
