package com.gpcoder.powermock.private_constructor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService.class)
public class ConstructorTest {

	@Mock
	private UserDaoImpl userDao;
	
	@Test
	public void privateConstructorTest() throws Exception {
		Mockito.doNothing().when(userDao).insert();
		PowerMockito.whenNew(UserDaoImpl.class).withNoArguments().thenReturn(userDao);
		UserService userService = UserService.createInstance();
		
		userService.insert();
		
		Mockito.verify(userDao).insert();
	}
}
