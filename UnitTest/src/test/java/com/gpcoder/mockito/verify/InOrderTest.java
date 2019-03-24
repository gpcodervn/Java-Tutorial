package com.gpcoder.mockito.verify;

import java.util.List;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

public class InOrderTest {

	@Test
	public void singleMockTest() {
		// Create mock object
		List<String> mockedList = Mockito.mock(List.class);

		// Using mock object
		mockedList.add("was added first");
		mockedList.add("was added second");

		// Create an inOrder verifier for a single mock
		InOrder inOrder = Mockito.inOrder(mockedList);

		// Following will make sure that add is first called with "was added first",
		// then with "was added second"
		inOrder.verify(mockedList).add("was added first");
		inOrder.verify(mockedList).add("was added second");
	}

	@Test
	public void multipleMocksTest() {
		// Create mock object
		List<String> mockedList1 = Mockito.mock(List.class);
		List<String> mockedList2 = Mockito.mock(List.class);

		// Using mock object
		mockedList1.add("was added first for 1st list");
		mockedList2.add("was added first for 2nd list");
		mockedList1.add("was added second for 1st list");

		// Create inOrder object passing any mocks that need to be verified in order
		InOrder inOrder = Mockito.inOrder(mockedList1, mockedList2);

		// Following will make sure that firstMock was called before secondMock
		inOrder.verify(mockedList1).add(Mockito.anyString());
		inOrder.verify(mockedList2).add(Mockito.anyString());
		inOrder.verify(mockedList1).add(Mockito.anyString());
	}

	@Test
	public void verifyOrderingExecutionTest() {
		// Create mock object
		UserCreationTemplate mockedObject = Mockito.spy(UserCreationTemplate.class);

		// Using mock object
		mockedObject.createUser();

		// Create inOrder object passing any mocks that need to be verified in order
		InOrder inOrder = Mockito.inOrder(mockedObject);

		// Verify ordering execution
		inOrder.verify(mockedObject).createUserCode();
		inOrder.verify(mockedObject).saveUser();
		inOrder.verify(mockedObject).sendEmail();
		inOrder.verify(mockedObject).showResult();
	}
}
