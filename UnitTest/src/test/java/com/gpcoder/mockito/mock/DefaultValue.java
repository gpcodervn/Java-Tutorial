package com.gpcoder.mockito.mock;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

public interface DefaultValue {

	int getInt();

	Integer getInteger();

	double getDouble();

	boolean getBoolean();

	String getObject();

	Collection<String> getCollection();

	String[] getArray();

	Stream<?> getStream();

	Optional<?> getOptional();
}
