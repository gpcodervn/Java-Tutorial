package com.gpcoder.powermock.final_clazz;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ FinalClazz.class })
public class FinalClazzTest {

	@Test
	public void mockFinalClazzTest() {
		FinalClazz mockedObject = PowerMockito.mock(FinalClazz.class);
		PowerMockito.when(mockedObject.doSomething()).thenReturn("gpcoder.com");
		
		Assert.assertEquals("gpcoder.com", mockedObject.doSomething());
	}

	@Test
	public void spyFinalClazzTest() {
		FinalClazz mockedObject = PowerMockito.spy(new FinalClazz());
		Assert.assertEquals("gpcoder.com", mockedObject.doSomething());
	}
}
