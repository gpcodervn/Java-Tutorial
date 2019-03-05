package com.gpcoder.junit.rule.custom;

import java.io.IOException;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class ScreenshotRule implements TestRule {

	public Statement apply(final Statement base, final Description description) {
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				System.out.println("Before test");
				try {
					base.evaluate();
				} catch (Throwable t) {
					takeScreenshot();
					throw t; // Report failure to JUnit
				} finally {
					System.out.println("After test");
				}
			}

			private void takeScreenshot() throws IOException {
				System.out.println("Take a screen shot and save to image file");
			}
		};
	}
}