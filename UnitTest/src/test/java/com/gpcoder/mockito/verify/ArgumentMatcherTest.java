package com.gpcoder.mockito.verify;

import static org.hamcrest.Matchers.hasItem;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ArgumentMatcherTest {

	@Captor
	private ArgumentCaptor<List<String>> captor;

	@Mock
	private List<String> mockedList;

	@Before
	public void prepareForTest() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public final void argumentCaptorTest() {
		List<String> asList = Arrays.asList("gpcoder.com", "mockito", "junit");

		mockedList.addAll(asList);

		// Verify value on arguments
		Mockito.verify(mockedList).addAll(captor.capture());
		final List<String> capturedArgument = captor.getValue();
		Assert.assertEquals(3, capturedArgument.size());
		Assert.assertThat(capturedArgument, hasItem("gpcoder.com"));
	}

	@Test
	public void argumentMatcherTest() {
		List<String> asList = Arrays.asList("gpcoder.com", "mockito", "junit");

		mockedList.addAll(asList);

		// Verifies certain behavior happened at at least once with the given value is
		// "gpcoder.com"
		Mockito.verify(mockedList).addAll(Mockito.anyCollection());
		Mockito.verify(mockedList, Mockito.atLeast(1))
				.addAll(Mockito.argThat(collection -> collection.contains("gpcoder.com")));
	}
}
