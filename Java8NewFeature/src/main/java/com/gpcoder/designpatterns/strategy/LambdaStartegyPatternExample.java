package com.gpcoder.designpatterns.strategy;

import java.util.Arrays;
import java.util.List;

public class LambdaStartegyPatternExample {

	public static void main(String[] args) {
		Strategy eagerStrategy = () -> System.out.println("Eager strategy");
		Strategy lazyStrategy = () -> System.out.println("Lazy strategy");
		List<Strategy> strategies = Arrays.asList(eagerStrategy, lazyStrategy);
		strategies.forEach((elem) -> elem.performTask());
	}
}
