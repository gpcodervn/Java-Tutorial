package com.gpcoder.mockito;

import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

// @RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class MockitoExampleTest {

	@Rule
	public MockitoRule rule = MockitoJUnit.rule();

	@Mock
	private List<String> list;

	@Before
	public void initMocks() {
		// MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldDoSomething() {
		list.add("gpcoder.com");
	}
}
