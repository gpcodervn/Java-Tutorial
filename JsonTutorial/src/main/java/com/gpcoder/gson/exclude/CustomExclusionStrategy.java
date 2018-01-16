package com.gpcoder.gson.exclude;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.gpcoder.gson.object.User;

public class CustomExclusionStrategy implements ExclusionStrategy {

	@Override
	public boolean shouldSkipField(FieldAttributes f) {
		// true if the field should be ignored; otherwise false
		return (f.getDeclaringClass() == User.class && f.getName().equals("password"));
	}

	@Override
	public boolean shouldSkipClass(Class<?> clazz) {
		// true if the class should be ignored; otherwise false
		return false;
	}

}