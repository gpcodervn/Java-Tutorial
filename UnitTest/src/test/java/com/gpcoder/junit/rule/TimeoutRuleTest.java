package com.gpcoder.junit.rule;

import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class TimeoutRuleTest {

	/**
	 * Creates a Timeout that will timeout a test after the given duration, in
	 * milliseconds.
	 */
	@Rule
	public Timeout timeout = Timeout.millis(3000);

	@Test
	public void testA() throws Exception {
		try {
			// Do normal task
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testB() throws Exception {
		try {
			// Do heavy task
			TimeUnit.SECONDS.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
