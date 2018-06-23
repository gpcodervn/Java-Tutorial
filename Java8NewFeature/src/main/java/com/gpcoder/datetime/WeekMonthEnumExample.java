package com.gpcoder.datetime;

import java.time.DayOfWeek;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class WeekMonthEnumExample {

	public static void main(String[] args) {
		
		// DayOfWeek Enum Example
		DayOfWeek monday = DayOfWeek.MONDAY;
		System.out.println(monday); // MONDAY
		System.out.println(monday.getDisplayName(TextStyle.SHORT, Locale.getDefault())); // Mon
		System.out.println(monday.getDisplayName(TextStyle.FULL, Locale.getDefault())); // Monday
		System.out.println(monday.plus(5)); // SATURDAY
		System.out.println(DayOfWeek.of(1)); // MONDAY
		System.out.println(DayOfWeek.of(7)); // SUNDAY
		System.out.println(DayOfWeek.valueOf("SUNDAY")); // SUNDAY
		System.out.println(monday.compareTo(DayOfWeek.SUNDAY)); // -6
		
		// Month Enum Example
		Month april = Month.APRIL;
		System.out.println(april); // APRIL
		System.out.println(april.getDisplayName(TextStyle.SHORT, Locale.getDefault())); // Apr
		System.out.println(april.getDisplayName(TextStyle.FULL, Locale.getDefault())); // April
		System.out.println(april.plus(3)); // JULY
		System.out.println(Month.FEBRUARY.maxLength()); // 29
		System.out.println(Month.FEBRUARY.minLength()); // 28
		System.out.println(april.firstDayOfYear(true)); // 92
		System.out.println(Month.of(1)); // JANUARY
		System.out.println(Month.of(12)); // DECEMBER
		System.out.println(Month.valueOf("FEBRUARY")); // FEBRUARY
		System.out.println(april.compareTo(Month.FEBRUARY)); // 2
	}
}
