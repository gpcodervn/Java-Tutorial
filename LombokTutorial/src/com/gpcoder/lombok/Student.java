package com.gpcoder.lombok;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	private Long id;

	private String name;

	private String clazz;

	private Date birthday;
}
