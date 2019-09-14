package com.gpcoder.designpatterns.strategy;

import java.util.Arrays;
import java.util.List;

class EagerStrategy implements Strategy {

	@Override
	public void performTask() {
		System.out.println("Eager strategy");
	}
}

class LazyStratgey implements Strategy {

	@Override
	public void performTask() {
		System.out.println("Lazy strategy");
	}
}

public class StartegyPatternExample {
	public static void main(String[] args) {
		Strategy eagerStrategy = new EagerStrategy();
		Strategy lazyStrategy = new LazyStratgey();
		List<Strategy> strategies = Arrays.asList(eagerStrategy, lazyStrategy);
		for (Strategy stg : strategies) {
			stg.performTask();
		}
	}
}
