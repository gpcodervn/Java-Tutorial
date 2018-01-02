package com.gpcoder.enumdemo;

public class EnumExample5 {
	enum WeekDay {
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
	}

	public static void main(String[] args) {
		WeekDay today = WeekDay.SUNDAY;

		switch (today) {
		case MONDAY:
			System.out.println("Today is working day");
			break;
		case SATURDAY:
		case SUNDAY:
			System.out.println("Today is holiday");
			break;
		default:
			System.out.println(today);
		}
	}
}