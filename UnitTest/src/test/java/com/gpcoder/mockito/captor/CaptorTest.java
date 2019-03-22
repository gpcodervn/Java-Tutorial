package com.gpcoder.mockito.captor;

import static org.hamcrest.Matchers.hasItem;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CaptorTest {

	@Captor
	private ArgumentCaptor<List<String>> captor;

	@Test
	public final void shouldHasListItem() {
		List<String> asList = Arrays.asList("gpcoder.com", "mockito", "junit");
		final List<String> mockedList = Mockito.mock(List.class);

		mockedList.addAll(asList);

		Mockito.verify(mockedList).addAll(captor.capture());
		Assert.assertEquals(0, mockedList.size()); // No changed because it is a mock object
		// Verify value on argument
		final List<String> capturedArgument = captor.getValue();
		Assert.assertEquals(3, capturedArgument.size());
		Assert.assertThat(capturedArgument, hasItem("gpcoder.com"));
	}
}
