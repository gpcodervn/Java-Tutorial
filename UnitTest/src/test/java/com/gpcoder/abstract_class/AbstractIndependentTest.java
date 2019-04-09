package com.gpcoder.abstract_class;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

public class AbstractIndependentTest {

	@Test
	public void testDefaultImplUsingConcreteClass() {
		AbstractIndependent testedObj = new AbstractIndependentImplTest();
		assertEquals("gpcoder", testedObj.defaultImpl());
	}

	@Test
	public void testDefaultImplUsingMockito() {
		AbstractIndependent testedObj = Mockito.spy(AbstractIndependent.class);
		assertEquals("gpcoder", testedObj.defaultImpl());
	}

	private class AbstractIndependentImplTest extends AbstractIndependent {

		@Override
		public int abstractMethod() {
			return 0;
		}

	}
}
