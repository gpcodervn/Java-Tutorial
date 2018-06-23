package com.gpcoder.datetime;

import java.time.Duration;
import java.time.Instant;

public class InstantExample {

	public static void main(String[] args) {

		// Current timestamp
		Instant now = Instant.now();
		System.out.println("Current Timestamp = " + now);

		// Instant from timestamp
		Instant specificTime = Instant.ofEpochMilli(now.toEpochMilli());
		System.out.println("Specific Time = " + specificTime);

		// Obtain an instance of Instant from a text string
		Instant specifyString = Instant.parse("2018-06-20T10:37:30.00Z");
		System.out.println("specifyString = " + specifyString);
		
		// Obtains a Duration representing a number of standard 24 hour days
		// return Duration with format of days*24
		Duration thirtyDay = Duration.ofDays(30);
		System.out.println(thirtyDay);

		// Copy of this instant with the specified amount subtracted
		Instant minus5 = now.minus(Duration.ofDays(5));
		System.out.println("minus5 = " + minus5);

		// Copy of this instant with the specified amount added
		Instant plus5 = now.plus(Duration.ofDays(5));
		System.out.println("plus5 = " + plus5);
	}
}
