package com.gpcoder.mockito.mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import java.util.Collections;

import org.junit.Test;
import org.mockito.Mockito;

public class DefaultValueOfMockObjectTest {

	@Test
	public void test() {
		DefaultValue demo = Mockito.mock(DefaultValue.class);
		assertEquals(0, demo.getInt());
		assertEquals(0, demo.getInteger().intValue());
		assertEquals(0d, demo.getDouble(), 0d);
		assertFalse(demo.getBoolean());
		assertNull(demo.getObject());
		assertEquals(Collections.emptyList(), demo.getCollection());
		assertNull(demo.getArray());
		assertEquals(0L, demo.getStream().count());
		assertFalse(demo.getOptional().isPresent());
	}
}
