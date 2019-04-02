package com.gpcoder.powermock.suppress.newInstance;

import org.junit.Assert;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

public class WhiteboxNewInstanceTest {

	@Test
	public void testSuppressOwnConstructor() {
		WhiteboxNewInstance tested = Whitebox.newInstance(WhiteboxNewInstance.class);
		Assert.assertNotNull(tested.getValue());
	}
}
