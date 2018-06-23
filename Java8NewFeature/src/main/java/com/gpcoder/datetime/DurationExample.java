package com.gpcoder.datetime;

import java.time.Duration;
import java.time.LocalDateTime;

public class DurationExample {

	public static void main(String[] args) {

		LocalDateTime firstDate = LocalDateTime.now();
		LocalDateTime secondDate = LocalDateTime.of(2018, 6, 20, 0, 0, 0);
		System.out.println("firstDate: " + firstDate); // 2018-06-23T21:31:28.924
		System.out.println("secondDate: " + secondDate); // 2018-06-20T00:00

		// Obtains a Duration representing the duration between two temporal objects
		// The temporal objects are Instant or LocalDateTime
		Duration duration = Duration.between(firstDate, secondDate);
		System.out.println("duration: " + duration); // PT-93H-31M-28.924S

		long days = duration.toDays();
		long hours = duration.toHours();
		long minutes = duration.toMinutes();
		long seconds = duration.getSeconds();
		long millis = duration.toMillis();
		long nanos = duration.toNanos();
		System.out.println("days: " + days); // -3
		System.out.println("hours: " + hours); // -93
		System.out.println("minutes: " + minutes); // -5611
		System.out.println("seconds: " + seconds); // -336689
		System.out.println("millis: " + millis); // -336688924
		System.out.println("nanos: " + nanos); // -336688924000000
		
		Duration twoHours = Duration.ofHours(2);
		System.out.println("twoHours: " + twoHours); // PT2H
		
		LocalDateTime plusDate = firstDate.plus(twoHours);
		System.out.println("plusDate: " + plusDate); // 2018-06-23T23:35:21.045
		
		LocalDateTime minusDate = firstDate.minus(twoHours);
		System.out.println("minusDate: " + minusDate); // 2018-06-23T19:35:21.045
	}
}
