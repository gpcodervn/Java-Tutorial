package com.gpcoder.format;

import java.util.Calendar;

public class StringFormat {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(2017, 11, 4);

		// Format the month.
		System.out.printf("Month: %1$tB %1$tb %1$tm \n", cal);

		// Format the day.
		System.out.printf("Day: %1$tA %1$ta %1$td \n", cal);

		// Format the year.
		System.out.printf("Year: %1$tY %1$ty %1$tj \n", cal);
		
		// Format the hour.
		System.out.printf("Hour: %1$tH %1$tI %1$tk %1$tl \n", cal);

        // Format minute.
		System.out.printf("Minute: %1$tM \n", cal);

        // Format the second.
		System.out.printf("Second: %1$tS \n", cal);

        // Format the am and pm part.
		System.out.printf("AM/PM: %1$tp \n", cal);
	}
}
