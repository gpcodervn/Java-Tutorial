package com.gpcoder.annotation;

import java.util.Date;

public class Student {

	@ExcelColumn(index = 1, title = "#", description = "Student's id")
	private long id;

	@ExcelColumn(index = 2, title = "Tên")
	private String name;

	@ExcelColumn(index = 3, title = "Tuổi ")
	private int age;

	@ExcelColumn(index = 4, title = "Ngày sinh")
	private Date birthday;

}
