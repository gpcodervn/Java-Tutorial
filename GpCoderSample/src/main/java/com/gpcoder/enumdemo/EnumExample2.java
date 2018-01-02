package com.gpcoder.enumdemo;

public class EnumExample2 {
	enum WeekDay {
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
	}

	public static void main(String[] args) {
		WeekDay today = WeekDay.SUNDAY;

		// use equal() method
		if (today.equals(WeekDay.SUNDAY)) {
			System.out.println("Today is holiday");
		} else {
			System.out.println("Today is working day");
		}

		// use == operator
		if (today == WeekDay.SUNDAY) {
			System.out.println("Today is holiday");
		} else {
			System.out.println("Today is working day");
		}
	}
}