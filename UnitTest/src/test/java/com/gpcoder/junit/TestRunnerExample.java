package com.gpcoder.junit;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunnerExample {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(AssertTest.class);

		System.out.println("Test result: " + result.wasSuccessful());
		System.out.println("Total of runtime in milliseconds: " + result.getRunTime());
		System.out.println("Number of tests run: " + result.getRunCount());
		System.out.println("Number of tests ignore: " + result.getIgnoreCount());
		System.out.println("Number of tests failure: " + result.getFailureCount());
		for (Failure failure : result.getFailures()) {
			System.out.println("Failed -> " + failure.toString());
		}
	}
}
