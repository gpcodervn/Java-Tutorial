package com.gpcoder.powermock.suppress.suppress_field;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SuppressField.class)
public class SuppressFieldTest {

	@Test
	public void testSuppressField() throws Exception {
		PowerMockito.suppress(PowerMockito.field(SuppressField.class, "username"));
		SuppressField tested = new SuppressField();
		Assert.assertNull(tested.getUsername());
	}
}
