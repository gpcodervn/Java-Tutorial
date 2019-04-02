package com.gpcoder.powermock.suppress.suppress_constructor;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ChildService.class)
public class SuppressConstructorTest {

	@Test
	public void testSuppressConstructorOfEvilParent() throws Exception {
		PowerMockito.suppress(PowerMockito.constructor(BaseService.class));
		final String message = "gpcoder.com";
		ChildService tested = new ChildService(message);
		Assert.assertEquals(message, tested.getMessage());
	}
}
