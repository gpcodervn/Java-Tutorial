package com.gpcoder.lambda;

import java.util.Comparator;
import java.util.List;

class NumberTest {

	public static boolean isOdd(int i) {
	    return i % 2 != 0;
	}

	public static boolean isGreaterThan3(int i){
	    return i > 3;
	}

	public static boolean isLessThan11(int i){
	    return i < 11;
	}

}

public class LambdaExpression7 {

	public static int findSquareOfMaxOdd_beforeJava8(List<Integer> numbers) {
		int max = 0;
		for (int i : numbers) {
			if (NumberTest.isOdd(i) && 
					NumberTest.isGreaterThan3(i) && 
					NumberTest.isLessThan11(i) && 
					i > max) {
				max = i;
			}
		}
		return max * max;
	}

	public static int findSquareOfMaxOdd_java8(List<Integer> numbers) {
		return numbers.stream()
				.filter(NumberTest::isOdd)
				.filter(NumberTest::isGreaterThan3)
				.filter(NumberTest::isLessThan11)
				.max(Comparator.naturalOrder())
				.map(i -> i * i)
				.get();
	}

}
