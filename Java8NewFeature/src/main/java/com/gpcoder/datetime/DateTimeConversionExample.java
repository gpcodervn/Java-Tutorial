package com.gpcoder.datetime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateTimeConversionExample {

	public static void main(String[] args) {

		// LocalDate/ LocalTime <-> LocalDateTime/ ZonedDateTime
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		LocalDateTime dateTimeFromDateAndTime = LocalDateTime.of(date, time);
		LocalDate dateFromDateTime = dateTimeFromDateAndTime.toLocalDate();
		LocalTime timeFromDateTime = dateTimeFromDateAndTime.toLocalTime();
		ZonedDateTime hcmDateTime = ZonedDateTime.of(dateTimeFromDateAndTime, ZoneId.of("Asia/Ho_Chi_Minh"));

		// Convert old classes to Java 8 Date Time
		Instant instantFromDate = new Date().toInstant();
		ZoneId zoneId = TimeZone.getDefault().toZoneId();
		Instant instantFromCalendar = Calendar.getInstance().toInstant();
		ZonedDateTime zonedDateTime = new GregorianCalendar().toZonedDateTime();

		// Instant <-> LocalDateTime
		Instant instant = Instant.now();
		LocalDateTime dateTimeFromInstant = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
		Instant instantFromLocalDateTime = dateTimeFromInstant.toInstant(ZoneOffset.ofHours(+7));

		// Instant <-> LocalDate
		LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
		Instant instantFromLocalDate = localDate.atStartOfDay(ZoneId.systemDefault()).toInstant();

		// Convert Java 8 Date Time to old classes
		Date dateFromInstant = Date.from(Instant.now());
		TimeZone timeZone = TimeZone.getTimeZone(ZoneId.of("Asia/Ho_Chi_Minh"));
		GregorianCalendar gregorianCalendar = GregorianCalendar.from(ZonedDateTime.now());
	}
}
