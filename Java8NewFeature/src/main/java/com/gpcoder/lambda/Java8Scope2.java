package com.gpcoder.lambda;

public class Java8Scope2 {

	static int outerStaticNum;
	int outerNum;

	void testScopes() {
		Converter<Integer, String> stringConverter1 = (from) -> {
			outerNum = 1;
			return String.valueOf(from);
		};

		Converter<Integer, String> stringConverter2 = (from) -> {
			outerStaticNum = 1;
			return String.valueOf(from);
		};
	}

}
