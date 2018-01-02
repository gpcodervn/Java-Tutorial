package com.gpcoder.enumdemo;

public class EnumExample4 {
	enum WeekDay {
		// Khởi tạo các phần tử từ construnctor
		// Các phần tử này luôn là static final
		MONDAY(2), TUESDAY(3), WEDNESDAY(4), THURSDAY(5), FRIDAY(7), SATURDAY(7), SUNDAY(1);

		private int value;

		// constructor này chỉ dùng trong nội bộ Enum
		// Modifier của constructor enum luôn là private
		// Nếu không khai báo private, java cũng sẽ hiểu là private.
		WeekDay(int value) {
			this.value = value;
		}

		// Có thể viết một static method lấy ra WeekDay theo value.
		public static WeekDay getWeekDayByValue(int value) {
			for (WeekDay d : WeekDay.values()) {
				if (d.value == value) {
					return d;
				}
			}
			return null;
		}
	}

	public static void main(String[] args) {
		for (WeekDay d : WeekDay.values()) {
			System.out.println(d + " = " + d.value);
		}

		// Sử dụng static method của enum
		WeekDay d = WeekDay.getWeekDayByValue(3);
		System.out.println("value 3 is " + d);
	}
}