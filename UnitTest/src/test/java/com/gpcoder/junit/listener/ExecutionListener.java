package com.gpcoder.junit.listener;

import org.junit.Ignore;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class ExecutionListener extends RunListener {

	private long startTime;
	private long endTime;

	/**
	 * Called before any tests have been run.
	 */
	@Override
	public void testRunStarted(Description description) throws java.lang.Exception {
		System.out.println("Tests started! Number of tests to execute : " + description.testCount());
		startTime = System.currentTimeMillis();
	}

	/**
	 * Called when all tests have finished
	 */
	@Override
	public void testRunFinished(Result result) throws java.lang.Exception {
		System.out.println("Tests finished! Number of tests executed: " + result.getRunCount());

		endTime = System.currentTimeMillis();
		long elapsedMiliSeconds = endTime - startTime;
		System.out.println("Elapsed time of tests execution: " + elapsedMiliSeconds + " milliseconds");
	}

	/**
	 * Called when an atomic test is about to be started.
	 */
	@Override
	public void testStarted(Description description) throws java.lang.Exception {
		System.out.println(String.format("Starting execution of test case : %s()", description.getMethodName()));
	}

	/**
	 * Called when an atomic test has finished, whether the test succeeds or fails.
	 */
	@Override
	public void testFinished(Description description) throws java.lang.Exception {
		System.out.println(String.format("Finished execution of test case : %s()", description.getMethodName()));
	}

	/**
	 * Called when an atomic test fails.
	 */
	@Override
	public void testFailure(Failure failure) throws java.lang.Exception {
		System.out.println(String.format("Execution of test case failed : %s('%s')",
				failure.getDescription().getMethodName(), failure.getMessage()));
	}

	/**
	 * Called when a test will not be run, generally because a test method is
	 * annotated with Ignore.
	 */
	@Override
	public void testIgnored(Description description) throws java.lang.Exception {
		Ignore ignore = description.getAnnotation(Ignore.class);
		String ignoreMessage = String.format("Execution of test case ignored : %s('%s')", description.getMethodName(),
				ignore.value());
		System.out.println(ignoreMessage);
	}
}
