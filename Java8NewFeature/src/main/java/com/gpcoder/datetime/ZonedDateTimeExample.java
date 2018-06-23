package com.gpcoder.datetime;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Set;

public class ZonedDateTimeExample {

	public static void main(String[] args) {

		// Get all available zones
		Set<String> allZoneIds = ZoneId.getAvailableZoneIds();
		System.out.println("allZoneIds = " + allZoneIds);
		
		ZoneId zoneHCM = ZoneId.of("Asia/Ho_Chi_Minh");

		// Creating LocalDateTime by providing input arguments
		LocalDateTime today = LocalDateTime.now();
		System.out.println("LocalDateTime = " + today);

		// Creating ZonedDateTime by providing input arguments
		ZonedDateTime hcmDateTime = ZonedDateTime.of(today, zoneHCM);
		System.out.println("ZonedDateTime = " + hcmDateTime);
		
		// using offsets
		ZoneOffset offset = ZoneOffset.of("+05:00");
		System.out.println("offset = " + offset);
		
		OffsetDateTime todayPlusFive = OffsetDateTime.of(today, offset);
		System.out.println("todayPlusFive = " + todayPlusFive);

		OffsetDateTime todayMinusTwo = todayPlusFive.withOffsetSameInstant(ZoneOffset.ofHours(-2));
		System.out.println("todayMinusTwo = " + todayMinusTwo);
	}
}
