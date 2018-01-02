package com.gpcoder;

import java.util.Calendar;

public class CalendarDemo {

	public static void calendarField() {
		// Tạo một đối tượng Calendar (Lịch) mặc định.
		// Với time zone (múi giờ) và locale mặc định.
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);

		// Trả về giá trị từ 0 - 11
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		int millis = c.get(Calendar.MILLISECOND);

		System.out.println("Year: " + year);
		System.out.println("Month: " + (month + 1));
		System.out.println("Day: " + day);
		System.out.println("Hour: " + hour);
		System.out.println("Minute: " + minute);
		System.out.println("Second: " + second);
		System.out.println("Minute: " + minute);
		System.out.println("Milli Second: " + millis);

	}

	public static void showCalendar(Calendar c) {
		int year = c.get(Calendar.YEAR);

		// Trả về giá trị từ 0 - 11
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		int millis = c.get(Calendar.MILLISECOND);

		System.out.println(" " + year + "-" + (month + 1) + "-" + day //
				+ " " + hour + ":" + minute + ":" + second + " " + millis);
	}

	public static void main(String[] args) {
		// Các field trong calendar
		System.out.println("Calendar fields");
		calendarField();
		System.out.println("---");

		// Tạo đối tượng Calendar, mô tả thời điểm hiện tại.
		// Với time zone (múi giờ) và locale mặc định.
		Calendar c = Calendar.getInstance();

		System.out.println("First calendar info");
		showCalendar(c);

		// roll(..): Cuộn một trường (field) của Calendar.
		// roll(..): Không làm thay đổi các trường khác.
		// Ví dụ: Cuộn lên thêm một giờ (boolean up = true)
		c.roll(Calendar.HOUR_OF_DAY, true);

		System.out.println("After roll 1 hour");
		showCalendar(c);

		// roll(..): Không làm thay đổi các trường khác của Calendar.
		// Cuộn xuống một giờ (boolean up = false)
		c.roll(Calendar.HOUR_OF_DAY, false);

		System.out.println("After roll -1 hour");
		showCalendar(c);

		// add(..): Có thể làm thay đổi các trường khác của Calendar.
		// Tăng thêm một giờ (boolean up = true)
		c.add(Calendar.HOUR_OF_DAY, 1);

		System.out.println("After add 1 hour");
		showCalendar(c);

		// roll(..): Không làm thay đổi các trường khác của Calendar.
		// Cuộn xuống 30 ngày.
		c.roll(Calendar.DAY_OF_MONTH, -30);

		System.out.println("After roll -30 day");
		showCalendar(c);

		// add(..): Có thể làm thay đổi các trường khác của Calendar.
		// Thêm 30 ngày.
		c.add(Calendar.DAY_OF_MONTH, 30);
		System.out.println("After add 30 day");
		showCalendar(c);

	}

}