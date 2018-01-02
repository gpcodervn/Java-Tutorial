package com.gpcoder.enumdemo;

import com.gpcoder.enumdemo.EnumExample2.WeekDay;

public class EnumExample3 {
	enum WeekDay {
		MONDAY(2), TUESDAY(3), WEDNESDAY(4), THURSDAY(5), FRIDAY(7), SATURDAY(7), SUNDAY(1);

		private int value;

		WeekDay(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			if (value == 1) { // other way: if (this == SUNDAY) {
				return "Today is holiday";
			} else {
				return "Today is working day";
			}
		}
	}

	public static void main(String[] args) {
		WeekDay today = WeekDay.SUNDAY;
		System.out.println(today);
		System.out.println(today.toString());
	}
}