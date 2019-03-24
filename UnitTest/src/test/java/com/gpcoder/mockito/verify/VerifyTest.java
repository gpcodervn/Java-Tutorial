package com.gpcoder.mockito.verify;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class VerifyTest {

	private List<String> mockedList;

	@Before
	public void prepareForTest() {
		// Mock creation
		mockedList = Mockito.mock(List.class);
	}

	@Test
	public void zeroTimeTest() {
		// Verifies certain behavior never happened
		Mockito.verify(mockedList, Mockito.never()).add("gpcoder.com");
		Mockito.verify(mockedList, Mockito.times(0)).add("gpcoder.com");
	}

	@Test
	public void oneTimeTest() {
		// Using mock object
		mockedList.add("gpcoder.com");

		// Verifies certain behavior happened once
		Mockito.verify(mockedList).add("gpcoder.com"); // Default one time
		Mockito.verify(mockedList, Mockito.times(1)).add("gpcoder.com");
	}

	@Test
	public void atLeastTest() {
		// Using mock object
		mockedList.add("one");
		mockedList.add("two");
		mockedList.add("three");

		// Verifies certain behavior happened at least once
		Mockito.verify(mockedList, Mockito.atLeastOnce()).add(Mockito.anyString());

		// Verifies certain behavior happened at least twice
		Mockito.verify(mockedList, Mockito.atLeast(2)).add(Mockito.anyString());
	}

	@Test
	public void atMostTest() {
		// Using mock object
		mockedList.add("one");
		mockedList.add("two");

		// Verifies certain behavior happened at most twice
		Mockito.verify(mockedList, Mockito.atMost(2)).add(Mockito.anyString());
	}

	@Test
	public void verifyNoMoreInteractionsTest() {
		// Create mock object
		List<String> mockOne = Mockito.mock(List.class);

		// Using mocks - only mockOne is interacted
		mockOne.add("one");

		// Uncomment this code will make the test case failed because it is unverified interaction
		// mockOne.get(0);

		// Ordinary verification
		Mockito.verify(mockOne).add("one");

		// Checks if any of given mocks has any unverified interaction. You can use this
		// method after you verified your mocks - to make sure that nothingelse was
		// invoked on your mocks.
		Mockito.verifyNoMoreInteractions(mockOne);
	}

	@Test
	public void verifyZeroInteractionsTest() {
		// Create mock object
		List<String> mockOne = Mockito.mock(List.class);
		List<String> mockTwo = Mockito.mock(List.class);
		List<String> mockThree = Mockito.mock(List.class);

		// Using mocks - only mockOne is interacted
		mockOne.add("one");

		// Ordinary verification
		Mockito.verify(mockOne).add("one");

		// Verify that method was never called on a mock
		Mockito.verify(mockOne, Mockito.never()).add("two");

		// Verifies that no interactions happened on given mocks beyond the previously
		// verified interactions
		Mockito.verifyZeroInteractions(mockTwo, mockThree);
	}

	@Test
	public void clearInvocationsTest() {
		// Create mock object
		List<String> mockOne = Mockito.mock(List.class);
		List<String> mockTwo = Mockito.mock(List.class);

		// Using mocks - only mockOne is interacted
		mockOne.add("one");
		mockTwo.add("one");

		// Use this method in order to only clear invocations, when stubbing is non-trivial.
		Mockito.clearInvocations(mockOne, mockTwo);
		// Another way: reset() a mock so that it can be reused later
		// Mockito.reset(mockOne, mockTwo);

		// Verifies that no interactions happened on given mocks beyond the previously
		// verified interactions
		Mockito.verifyZeroInteractions(mockOne, mockTwo);
	}
}
