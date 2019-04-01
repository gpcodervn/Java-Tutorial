package com.gpcoder.powermock.private_method;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

@RunWith(PowerMockRunner.class)
@PrepareForTest(PrivateMethod.class)
public class PrivateMethodTest {

	@Test
	public void invokeMethodTest() throws Exception {
		PrivateMethod obj = new PrivateMethod();
		Whitebox.invokeMethod(obj, "setUsername", "gpcoder.com");

		Assert.assertEquals("gpcoder.com", obj.getUsername());
	}

	@Test
	public void setInternalStateTest() throws Exception {
		PrivateMethod obj = new PrivateMethod();
		Whitebox.setInternalState(obj, "username", "gpcoder.com");

		Assert.assertEquals("gpcoder.com", obj.getUsername());
	}

	@Test
	public void getInternalStateTest() throws Exception {
		PrivateMethod obj = new PrivateMethod();
		Whitebox.setInternalState(obj, "username", "gpcoder.com");

		Assert.assertEquals("gpcoder.com", Whitebox.getInternalState(obj, "username"));
	}

	@Test
	public void doNothingWhenCallPrivateMethod() throws Exception {
		PrivateMethod obj = PowerMockito.spy(new PrivateMethod());

		// Do nothing when resetUsername() was called
		PowerMockito.doNothing().when(obj, "setUsername", Mockito.anyString());

		obj.resetUsername();

		// Verify obj.resetUsername() was called
		PowerMockito.verifyPrivate(obj).invoke("setUsername", Mockito.anyString());
		// Verify username is null because setUsername() never executed
		Assert.assertNull(obj.getUsername());
	}
}
