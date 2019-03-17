package com.gpcoder.junit.retry;

import java.util.concurrent.TimeUnit;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class RetryRule implements TestRule {
	private int numberOfRetryTimes;
	private int delayInMiliseconds;

	public RetryRule(int numberOfRetryTimes, int delayInMiliseconds) {
		this.numberOfRetryTimes = numberOfRetryTimes;
		this.delayInMiliseconds = delayInMiliseconds;
	}

	public Statement apply(Statement base, Description description) {
		return statement(base, description);
	}

	private Statement statement(final Statement base, final Description description) {
		System.out.println(String.format("\nExecuting test: %s()", description.getMethodName()));
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				Throwable caughtThrowable = null;

				// Implement retry logic here
				for (int i = 0; i < numberOfRetryTimes; i++) {
					try {
						base.evaluate();
						return;
					} catch (Throwable t) {
						caughtThrowable = t;
						System.out.println(String.format("%s : run %d failed.", description.getDisplayName(), (i + 1)));
					}
					delay(delayInMiliseconds);
				}
				System.out.println(String.format("%s : giving up after %d failures.\n", description.getDisplayName(), numberOfRetryTimes));
				throw caughtThrowable;
			}
		};
	}
	
	private static void delay(int delayInMiliseconds) throws InterruptedException {
		System.out.println("Waiting for retry next time");
		TimeUnit.MICROSECONDS.sleep(delayInMiliseconds);
	}
}