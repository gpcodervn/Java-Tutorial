package com.gpcoder.junit;

import static org.junit.Assume.assumeNotNull;
import static org.junit.Assume.assumeTrue;

import org.junit.Test;

public class AssumeTest {

	@Test
	public void assumeTrueTest() {
		assumeTrue(true);
		System.out.println("execute test");
	}

	@Test
	public void assumeNotNullTest() {
		Object object = null;
		assumeNotNull(object);
		System.out.println("execute test");
	}
}
