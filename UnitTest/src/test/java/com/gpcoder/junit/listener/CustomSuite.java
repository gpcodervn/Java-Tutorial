package com.gpcoder.junit.listener;

import java.util.List;

import org.junit.AssumptionViolatedException;
import org.junit.internal.runners.model.EachTestNotifier;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runner.notification.StoppedByUserException;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;
import org.junit.runners.model.Statement;

public class CustomSuite extends Suite {

	public CustomSuite(Class<?> klass, List<Runner> runners) throws InitializationError {
		super(klass, runners);
	}

	public CustomSuite(Class<?> klass, RunnerBuilder builder) throws InitializationError {
		super(klass, builder);
	}

	public CustomSuite(RunnerBuilder builder, Class<?> klass, Class<?>[] suiteClasses) throws InitializationError {
		super(builder, klass, suiteClasses);
	}

	public CustomSuite(RunnerBuilder builder, Class<?>[] classes) throws InitializationError {
		super(builder, classes);
	}

	protected CustomSuite(Class<?> klass, Class<?>[] suiteClasses) throws InitializationError {
		super(klass, suiteClasses);
	}

	@Override
	public void run(RunNotifier notifier) {
		System.out.println("Executing run()");
		// Add Listener. This will register our JUnit Listener.
		notifier.addListener(new ExecutionListener());

		// Get each test notifier
		EachTestNotifier testNotifier = new EachTestNotifier(notifier, getDescription());
		try {
			// In order capture testRunStarted method
			// at the very beginning of the test run, we will add below code.
			// Invoke here the run testRunStarted() method
			notifier.fireTestRunStarted(getDescription());
			Statement statement = classBlock(notifier);
			statement.evaluate();
		} catch (AssumptionViolatedException e) {
			testNotifier.fireTestIgnored();
		} catch (StoppedByUserException e) {
			throw e;
		} catch (Throwable e) {
			testNotifier.addFailure(e);
		}
	}
}