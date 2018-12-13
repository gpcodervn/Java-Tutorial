package com.gpcoder;

import java.util.Arrays;

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
@PrepareForTest({ ServiceExecutor.class, Arrays.class })
public class FirstControllerTest_MockArrays {

	@Before
	public void prepareForTest() throws Exception {
		
		PowerMockito.mockStatic(Arrays.class);
		PowerMockito.when(Arrays.asList(Mockito.any())).thenReturn(null);
		
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