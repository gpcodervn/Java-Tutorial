package com.gpcoder.mockito.dothen;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.gpcoder.mockito.whenthen.CustomList;

public class DoWhenTest {

	private CustomList mockedObject;

	@Before
	public void prepareForTest() {
		// Mock creation
		mockedObject = Mockito.mock(CustomList.class);
	}

	@Test
	public void doReturnTest() {
		// Configure mock to return a specific value on a method call
		Mockito.doReturn("gpcoder.com").when(mockedObject).get(0);

		// Verify behavior
		Assert.assertEquals("gpcoder.com", mockedObject.get(0));
	}

	@Test(expected = IllegalStateException.class)
	public void doThrowTest() {
		// Configure mock to throw an exception on a method call
		Mockito.doThrow(IllegalStateException.class).when(mockedObject).add(Mockito.anyString());

		mockedObject.add("gpcoder.com");
	}

	@Test
	public void doAnswerTest1() {
		// Configure mock method call with custom Answer
		Mockito.doAnswer(new Answer<String>() {
			public String answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				// Object mockedObject = invocation.getMock();
				return "gpcoder.com" + Arrays.toString(args);
			}
		}).when(mockedObject).get(Mockito.anyInt());

		// Verify behavior
		Assert.assertEquals("gpcoder.com[1]", mockedObject.get(1));
	}

	@Test
	public void doAnswerTest2() {
		// Configure mock method call with custom Answer using Java 8 syntax
		Mockito.doAnswer(invocation -> {
			Object[] args = invocation.getArguments();
			// Object mockedObject = invocation.getMock();
			return "gpcoder.com" + Arrays.toString(args);
		}).when(mockedObject).get(Mockito.anyInt());

		// Verify behavior
		Assert.assertEquals("gpcoder.com[1]", mockedObject.get(1));
	}

	@Test
	public void doCallRealMethodTest() {
		// Configure mock method call real method
		// Be sure the real implementation is 'safe'.
		// If real implementation throws exceptions or depends on specific state of the
		// object then you're in trouble.
		Mockito.doCallRealMethod().when(mockedObject).add(Mockito.anyString());
		Mockito.doCallRealMethod().when(mockedObject).get(Mockito.anyInt());
		Mockito.doCallRealMethod().when(mockedObject).size();

		mockedObject.add("gpcoder.com");
		mockedObject.clear(); // This method will be not called on mocked object

		// Verify behavior
		Assert.assertEquals(1, mockedObject.size());
		Assert.assertEquals("gpcoder.com", mockedObject.get(0));
	}

	@Test
	public void doNothingTest() {
		// Configure mock method call with custom Answer using Java 8 syntax
		Mockito.doNothing().when(mockedObject).remove(0);
		
		mockedObject.remove(0);

		// Verify behavior
		Mockito.verify(mockedObject, Mockito.times(1)).remove(0);
	}
}
