package com.gpcoder.jackson.annotation;

import com.fasterxml.jackson.annotation.JsonValue;

public enum JsonValueExmaple {
	TYPE1(1, "Type 1"), TYPE2(2, "Type 2");

	private Integer id;
	private String name;

	private JsonValueExmaple(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	@JsonValue
	public String getName() {
		return name;
	}
}