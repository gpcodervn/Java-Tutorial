package com.gpcoder.collectors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

class Employee {
	private String name;
	private Integer age;
	private String companyName;
	private Integer salary;

	public Employee(String name, Integer age, String companyName, Integer salary) {
		this.name = name;
		this.age = age;
		this.companyName = companyName;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public String getCompanyName() {
		return companyName;
	}

	public Integer getSalary() {
		return salary;
	}
}

public class CollectorsExample4 {

	public static void main(String[] args) {
		
		List<Employee> list = Arrays.asList( //
				new Employee("Emp1", 22, "A", 50), //
				new Employee("Emp2", 23, "A", 60), //
				new Employee("Emp3", 22, "B", 40), //
				new Employee("Emp4", 21, "B", 70) //
		);

		// Find employees with the maximum age of each company
		Comparator<Employee> ageComparator = Comparator.comparing(Employee::getAge);

		Map<String, Optional<Employee>> map = list.stream().collect(
				Collectors.groupingBy(Employee::getCompanyName,
						Collectors.reducing(BinaryOperator.maxBy(ageComparator))));

		map.forEach((k, v) -> System.out.println(
				"Company: " + k + 
				", Age: " + ((Optional<Employee>) v).get().getAge() + 
				", Name: " + ((Optional<Employee>) v).get().getName()));
		
		// Summary salary
		Integer bonus = 30;
		Integer totalSalaryExpense = list.stream()
                .map(emp -> emp.getSalary())
				.reduce(bonus, (a, b) -> a + b);
		System.out.println("Total salary expense: " + totalSalaryExpense);
	}
}
