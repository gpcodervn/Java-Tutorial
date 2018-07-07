package com.gpcoder.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public class TypeAnnotations {

	@Target({ ElementType.TYPE_USE, ElementType.TYPE_PARAMETER })
	public @interface Test {
	}

	@Test
	private String str1 = "";
}
