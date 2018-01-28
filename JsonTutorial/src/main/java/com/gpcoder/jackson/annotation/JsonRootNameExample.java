package com.gpcoder.jackson.annotation;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "root")
public class JsonRootNameExample {
	public int id;
    public String name;
}
