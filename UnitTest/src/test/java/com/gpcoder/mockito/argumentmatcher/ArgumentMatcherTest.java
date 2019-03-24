package com.gpcoder.mockito.argumentmatcher;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Message {
	private String to;
	private String content;
}

class MessageMatcher implements ArgumentMatcher<Message> {

	private Message message;

	public MessageMatcher(Message message) {
		this.message = message;
	}

	// Informs if this matcher accepts the given argument. The method should never
	// assert if the argument doesn't match. Itshould only return false.
	@Override
	public boolean matches(Message message) {
		if (this.message.equals(message)) {
			return true;
		}
		return false;
	}
}

public class ArgumentMatcherTest {

	@Test
	public void anyIntTest() {
		List<String> mockedList = Mockito.mock(List.class);

		// Configure mock to return a specific value on a method call
		Mockito.when(mockedList.get(Mockito.anyInt())).thenReturn("gpcoder.com");
		Mockito.when(mockedList.add(Mockito.anyString())).thenReturn(true);

		// Verify behavior
		Assert.assertEquals(true, mockedList.add("gpcoder.com"));
		Assert.assertEquals(true, mockedList.add("mockito"));
		Assert.assertEquals("gpcoder.com", mockedList.get(0));
		Assert.assertEquals("gpcoder.com", mockedList.get(4));
	}

	@Test
	public void customArgumentMatcherTest() {
		List<Message> mockedList = Mockito.mock(List.class);

		Message message = new Message("gpcoder.com", "Custom Argument Matcher");

		// Configure mock to return a specific value on a method call
		Mockito.when(mockedList.add(Mockito.argThat(new MessageMatcher(message)))).thenReturn(true);

		// Verify behavior
		Assert.assertEquals(true, mockedList.add(message));
	}
}
