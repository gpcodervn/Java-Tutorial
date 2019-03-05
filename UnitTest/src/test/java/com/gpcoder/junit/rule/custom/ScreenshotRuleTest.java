package com.gpcoder.junit.rule.custom;

import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;

public class ScreenshotRuleTest {

	@Rule
	public ScreenshotRule screenshotRule = new ScreenshotRule();

	@Test
	public void testScreenShot() throws IOException {
		throw new IOException("Application is crashed");
	}
}
