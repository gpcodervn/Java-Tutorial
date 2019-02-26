package com.gpcoder.junit.staticblock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ServiceExecutorTest {

	@Test
	public void doSomethingTest() throws NoSuchFieldException, IllegalAccessException {
		Field field = null;
		List<Service> oldList = null;
		try {
			field = ServiceExecutor.class.getDeclaredField("services");
			field.setAccessible(true);
			Field modifiersField = Field.class.getDeclaredField("modifiers");
			modifiersField.setAccessible(true);
			modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

			final Service serviceMock1 = mock(Service.class);
			final Service serviceMock2 = mock(Service.class);
			final List<Service> serviceMockList = Arrays.asList(serviceMock1, serviceMock2);
			oldList = (List<Service>) field.get(null);
			field.set(null, serviceMockList);
			ServiceExecutor.execute();
			verify(serviceMock1, times(1)).execute();
			verify(serviceMock2, times(1)).execute();
		} finally {
			// restore original value
			if (field != null && oldList != null) {
				field.set(null, oldList);
			}
		}
	}

	static class Service {
		public Service() {
			// Heavy constructor
			System.out.println("Constructor of Service");
		}

		void execute() {
			throw new RuntimeException("Should not execute");
		}
	}

	static class ServiceExecutor {

		private static final List<Service> services = Arrays.asList(new Service());

		public static void execute() {
			for (Service s : services) {
				s.execute();
			}
		}
	}
}