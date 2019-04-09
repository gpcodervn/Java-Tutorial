package com.gpcoder.powermock.verify_static_method;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ UserUtils.class })
public class UserServiceTest {

	@Test
	public void verifyCalledStaticMethodTest() throws Exception {
		// Object under test
		UserService userService = new UserService();

		// Mock
		PowerMockito.mockStatic(UserUtils.class);
		PowerMockito.doNothing().when(UserUtils.class, "validate", Mockito.anyString());
		PowerMockito.when(UserUtils.class, "generateUniqueId").thenReturn(UUID.randomUUID().toString());

		// Execute method under test
		String actual = userService.insert();

		// Test
		Assert.assertEquals("gpcoder.com", actual);
		PowerMockito.verifyStatic(UserUtils.class, Mockito.times(2));
		UserUtils.validate(Mockito.anyString());
		PowerMockito.verifyStatic(UserUtils.class, Mockito.times(1));
		UserUtils.generateUniqueId();
	}
}
