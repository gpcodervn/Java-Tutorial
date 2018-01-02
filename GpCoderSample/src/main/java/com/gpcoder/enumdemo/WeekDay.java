package com.gpcoder.enumdemo;

public enum WeekDay {

	MONDAY(2), TUESDAY(3), WEDNESDAY(4), THURSDAY(5), FRIDAY(7), SATURDAY(7), SUNDAY(1);

	private int value;

	WeekDay(int value) {
		this.value = value;
	}
}
