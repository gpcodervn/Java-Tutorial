package com.gpcoder.powermock.suppress.suppress_static_initialization;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@SuppressStaticInitializationFor("com.gpcoder.powermock.suppress.suppress_static_initialization.LoginService")
public class SuppressStaticInitializationForTest {

	@Test
	public void testSuppressStaticInitializer() throws Exception {
		final String message = "gpcoder.com";
		LoginService tested = new LoginService(message);
		Assert.assertEquals(message, tested.getMessage());
	}
}
