package com.gpcoder;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.gpcoder.staticblock.FirstController;
import com.gpcoder.staticblock.ServiceExecutor;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ ServiceExecutor.class })
public class FirstControllerTest {

	@Before
	public void prepareForTest() throws Exception {
		PowerMockito.mockStatic(ServiceExecutor.class);
		PowerMockito.doNothing().when(ServiceExecutor.class);
	}

	@Test
	public void doSomethingTest() {
		FirstController firstController = new FirstController();
		firstController.doSomething();
		PowerMockito.verifyStatic(ServiceExecutor.class, Mockito.times(1));
	}
}