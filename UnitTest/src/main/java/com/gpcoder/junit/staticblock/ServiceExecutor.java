package com.gpcoder.junit.staticblock;

import java.util.Arrays;
import java.util.List;

public class ServiceExecutor {
	private static final List<Service> services = Arrays.asList(new Service1(), new Service2());

	public static void execute() {
		for (Service s : services) {
			s.execute();
		}
	}
}
