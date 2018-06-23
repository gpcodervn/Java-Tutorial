package com.gpcoder.datetime;

import java.time.LocalDate;
import java.time.Period;

public class PeriodExample {

	public static void main(String[] args) {

		LocalDate firstDate = LocalDate.now();
		LocalDate secondDate = LocalDate.of(2017, 5, 20);
		System.out.println("firstDate: " + firstDate); // 2018-06-23
		System.out.println("secondDate: " + secondDate); // 2017-05-20

		Period period = Period.between(firstDate, secondDate);
		System.out.println("period: " + period); // P-1M-3D

		int days = period.getDays();
		int months = period.getMonths();
		int years = period.getYears();
		boolean isNegative = period.isNegative();
		System.out.println("days: " + days); // -3
		System.out.println("months: " + months); // -1
		System.out.println("years: " + years); // -1
		System.out.println("isNegative: " + isNegative); // true

		Period twoMonthTenDays = Period.ofMonths(2).plusDays(10);
		System.out.println("twoMonthTenDays: " + twoMonthTenDays); // P2M10D
		
		LocalDate plusDate = firstDate.plus(twoMonthTenDays);
		System.out.println("plusDate: " + plusDate); // 2018-09-02
		
		LocalDate minusDate = firstDate.minus(twoMonthTenDays);
		System.out.println("minusDate: " + minusDate); // 2018-04-13
	}
}
