package com.gpcoder.datetime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateParseFormatExample {

	public static void main(String[] args) {

		// Format LocalDate examples
		LocalDate date = LocalDate.now();
		System.out.println("Default format of LocalDate = " + date);
		System.out.println(date.format(DateTimeFormatter.ofPattern("d::MMM::uuuu")));
		System.out.println(date.format(DateTimeFormatter.BASIC_ISO_DATE));

		// Format LocalDateTime examples
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println("\nDefault format of LocalDateTime = " + dateTime);
		System.out.println(dateTime.format(DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss")));
		System.out.println(dateTime.format(DateTimeFormatter.BASIC_ISO_DATE));

		// Format Instant Example
		Instant timestamp = Instant.now();
		System.out.println("\nDefault format of Instant = " + timestamp);

		// Parse examples
		LocalDateTime dt = LocalDateTime.parse("27::Apr::2014 21::39::48",
				DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss"));
		System.out.println("\nDefault format after parsing = " + dt);
	}
}
