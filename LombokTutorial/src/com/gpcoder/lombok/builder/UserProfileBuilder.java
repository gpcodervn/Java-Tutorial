package com.gpcoder.lombok.builder;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class UserProfileBuilder {
	
	private String name;

	private String language;

	private int experience;
	
}
