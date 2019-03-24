package com.gpcoder.mockito.whenthen;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IteratorThenReturnTest {

	private CustomList mockedObject;

	@Before
	public void prepareForTest() {
		// Mock creation
		mockedObject = Mockito.mock(CustomList.class);
	}

	@Test
	public void consecutiveStubbingTest1() {
		// Configure mock to return a specific value on a method call
		Mockito.when(mockedObject.get(0)).thenReturn("one").thenReturn("two").thenReturn("three");

		// Verify behavior
		Assert.assertEquals("one", mockedObject.get(0));
		Assert.assertEquals("two", mockedObject.get(0));
		// From 3rd times, it always return "three" value
		Assert.assertEquals("three", mockedObject.get(0));
		Assert.assertEquals("three", mockedObject.get(0));
		Assert.assertEquals("three", mockedObject.get(0));
	}

	@Test
	public void consecutiveStubbingTest2() {
		// Configure mock to return a specific value on a method call
		Mockito.when(mockedObject.get(0)).thenReturn("one", "two", "three");

		// Verify behavior
		Assert.assertEquals("one", mockedObject.get(0));
		Assert.assertEquals("two", mockedObject.get(0));
		// From 3rd times, it always return "three" value
		Assert.assertEquals("three", mockedObject.get(0));
		Assert.assertEquals("three", mockedObject.get(0));
		Assert.assertEquals("three", mockedObject.get(0));
	}

	@Test
	public void overrideStubbingTest() {
		// Configure mock to return a specific value on a method call
		Mockito.when(mockedObject.get(0)).thenReturn("first");
		Mockito.when(mockedObject.get(0)).thenReturn("second");

		// Verify behavior
		// All mockedObject.get(0) calls will return "second"
		Assert.assertEquals("second", mockedObject.get(0));
		Assert.assertEquals("second", mockedObject.get(0));
	}
}
