package com.gpcoder.powermock.final_method;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ FinalMethod.class })
public class FinalMethodTest {

	@Test
	public void mockFinalClazzTest() {
		FinalMethod mockedObject = PowerMockito.mock(FinalMethod.class);
		PowerMockito.when(mockedObject.doSomething()).thenReturn("gpcoder.com");

		Assert.assertEquals("gpcoder.com", mockedObject.doSomething());
	}

	@Test
	public void spyFinalClazzTest() {
		FinalMethod mockedObject = PowerMockito.spy(new FinalMethod());
		Assert.assertEquals("gpcoder.com", mockedObject.doSomething());
	}
}
