package com.gpcoder.predicate;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeePredicates {

	// Tất cả Employee có tuổi > 21 và có giới tính là Male
	public static Predicate<Employee> isAdultMale() {
		return p -> p.getAge() > 21 && p.getGender().equalsIgnoreCase("M");
	}

	// Tất cả Employee có tuổi > 18 và có giới tính là Female
	public static Predicate<Employee> isAdultFemale() {
		return p -> p.getAge() > 18 && p.getGender().equalsIgnoreCase("F");
	}

	// Tất cả Employee lớn hơn số tuổi được truyền vào
	public static Predicate<Employee> isAgeMoreThan(Integer age) {
		return p -> p.getAge() > age;
	}

	// Lấy danh sách Employee thõa mãn predicate được truyền vào
	public static List<Employee> filterEmployees( //
			List<Employee> employees, Predicate<Employee> predicate) {
		return employees.stream().filter(predicate).collect(Collectors.<Employee>toList());
	}
}
