package com.gpcoder.lombok.builder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class UserProfileEntity {
	
	private String name;

	private String language;

	private int experience;

}
