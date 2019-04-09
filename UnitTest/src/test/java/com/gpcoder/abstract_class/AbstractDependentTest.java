package com.gpcoder.abstract_class;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

public class AbstractDependentTest {

	private static final String URL_TEST = "gpcoder.com";

	@Test
	public void testDefaultImplUsingConcreteClass() {
		AbstractDependent testedObj = new AbstractDependentImplTest();
		Assert.assertEquals(1, testedObj.callApi(URL_TEST));
		Assert.assertEquals(0, testedObj.callApi("other the 'gpcoder.com' url"));
	}

	@Test
	public void testDefaultImplUsingMockito() {
		final int expected = 1;
		AbstractDependent testedObj = Mockito.spy(AbstractDependent.class);
		Mockito.doNothing().when(testedObj).preExecute(Mockito.anyString());
		Mockito.when(testedObj.postExecute(Mockito.anyInt())).thenReturn(expected);

		int actual = testedObj.callApi(URL_TEST);

		// Verify the result
		Assert.assertEquals(expected, actual);
		// Verify every methods was called in order
		InOrder inOrder = Mockito.inOrder(testedObj);
		inOrder.verify(testedObj).preExecute(Mockito.anyString());
		inOrder.verify(testedObj).execute(Mockito.anyString());
		inOrder.verify(testedObj).postExecute(Mockito.anyInt());
	}

	private class AbstractDependentImplTest extends AbstractDependent {

		@Override
		protected void preExecute(String url) {
			// do nothing
		}

		@Override
		protected int postExecute(int result) {
			return result;
		}
	}
}
